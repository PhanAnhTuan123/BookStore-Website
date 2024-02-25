package com.bookstore.service;

import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bookstore.controller.frontend.shoppingCart.ShoppingCart;
import com.bookstore.dao.CustomerDAO;
import com.bookstore.dao.OrderDAO;
import com.bookstore.entity.entity3.Book;
import com.bookstore.entity.entity3.BookOrder;
import com.bookstore.entity.entity3.Customer;
import com.bookstore.entity.entity3.OrderDetail;
import com.bookstore.enumeration.Payment_method;
import com.bookstore.enumeration.StatusBookOrder;

public class OrderServices {
	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;
	private HttpServletRequest request;
	private HttpServletResponse response;
	private OrderDAO orderDAO;

	public OrderServices(EntityManager entityManager, HttpServletRequest request, HttpServletResponse response) {

		this.entityManager = entityManager;
		this.request = request;
		this.response = response;
		orderDAO = new OrderDAO(entityManager);
	}

	public void listOrder() throws ServletException, IOException {
		List<BookOrder> listOrder = orderDAO.listAll();
		request.setAttribute("listOrder", listOrder);
		String listPage = "order_list.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(listPage);
		dispatcher.forward(request, response);
	}

	public void viewOrderDetailForAdmin() throws ServletException, IOException {

		int orderId = Integer.parseInt(request.getParameter("id"));
		BookOrder order = orderDAO.get(orderId);
		request.setAttribute("order", order);
		String detailPage = "frontend/order_detail.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(detailPage);
		dispatcher.forward(request, response);

	}

	public void showCheckoutForm() throws ServletException, IOException {
		String checkoutPage = "frontend/checkout.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(checkoutPage);
		dispatcher.forward(request, response);
	}

	public void placeOrder() throws ServletException, IOException {
		String recipientName = request.getParameter("recipientName");
		String recipientPhone = request.getParameter("recipientPhone");
		String address = request.getParameter("address");
		String city = request.getParameter("city");
		String zipcode = request.getParameter("zipcode");
		String country = request.getParameter("country");
		String paymentMethod = request.getParameter("paymentMethod");
		String shippingADdres = address + " , " + zipcode + "  , " + country;
		Payment_method payment = Payment_method.valueOf(paymentMethod);
		BookOrder order = new BookOrder();
		order.setRecipient_name(recipientName);
		order.setRecipient_phone(recipientPhone);
		order.setShipping_address(shippingADdres);
		order.setPayment_method(payment);
		HttpSession session = request.getSession();
		Customer customer = (Customer) session.getAttribute("loggedCustomer");
		order.setCustomer_id(customer);
		ShoppingCart shoppingCart = (ShoppingCart) session.getAttribute("cart");
		Map<Book, Integer> items = shoppingCart.getItems();
		Iterator<Book> iterator = items.keySet().iterator();
		Set<OrderDetail> orderDetails = new HashSet<OrderDetail>();
		while (iterator.hasNext()) {
			Book book = iterator.next();
			Integer quantity = items.get(book);
			float subTotal = (float) (quantity * book.getPrice());
			OrderDetail detail = new OrderDetail();
			detail.setBook(book);
			detail.setBookOrder(order);
			detail.setQuantity(quantity);
			detail.setSubtotal(subTotal);
			orderDetails.add(detail);
		}
		order.setDetail((List<OrderDetail>) orderDetails);
		order.setTotal(shoppingCart.getTotalAmount());
		orderDAO.create(order);
		shoppingCart.clear();
		String message = "Thank you. ytour order has been received." + "We will deliver your books within a few days";
		request.setAttribute("message", message);
		String messagePage = "frontend/message.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(messagePage);
		dispatcher.forward(request, response);

	}

	public void listOrderBuCustomer() {
		HttpSession session = request.getSession();
		Customer customer = (Customer) session.getAttribute("loggedCustomer");
		List<BookOrder> listOrders = orderDAO.listByCustomer(customer.getCustomerId());

		request.setAttribute("listOrders", listOrders);
	}

	public void showOrderDetailFOrCustomer() throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		BookOrder order = orderDAO.get(id);
		request.setAttribute("order", order);
		HttpSession session = request.getSession();
		Customer customer = (Customer) session.getAttribute("loggedCustomer");
		BookOrder updatedorder = orderDAO.get(customer, customer.getCustomerId());
		String messagePage = "frontend/order_detail.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(messagePage);
		dispatcher.forward(request, response);

	}

	public void showEditORder() throws ServletException, IOException {
		Integer id = Integer.parseInt(request.getParameter("id"));

		HttpSession session = request.getSession();
		Object isPendingBook = session.getAttribute("NewBookPendingToAddToOrder");
		if (isPendingBook == null) {
			BookOrder order = orderDAO.get(id);
			session.setAttribute("order", order);
		} else {
			session.removeAttribute("NewBookPendingToAddToOrder");
		}
//		session.setAttribute("editOrder", order);
//		request.setAttribute("order", order);
		String messagePage = "frontend/order_form.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(messagePage);
		dispatcher.forward(request, response);
	}

	public void updateOrder() throws ServletException, IOException {
		HttpSession session = request.getSession();
		BookOrder order = (BookOrder) session.getAttribute("order");
		String recipientName = request.getParameter("recipientName");
		String recipientPhone = request.getParameter("recipientPhone");
		String shippingAddress = request.getParameter("shippingAddress");
		String orderStatus = request.getParameter("orderStatus");
		String paymentMethod = request.getParameter("paymentMethod");

		order.setRecipient_name(recipientName);
		order.setRecipient_phone(recipientPhone);
		order.setShipping_address(shippingAddress);
		order.setPayment_method(Payment_method.valueOf(paymentMethod));
		order.setStatus(StatusBookOrder.valueOf(orderStatus));
		String[] arrrayBookId = request.getParameterValues("bookId");
		String[] arrayPrice = request.getParameterValues("price");
		String[] arrrayQuantity = new String[arrrayBookId.length];
		for (int i = 1; i < arrrayQuantity.length; i++) {
			arrrayQuantity[i-1] = request.getParameter("quantity" + i);
		}
		Set<OrderDetail> details = (Set<OrderDetail>) order.getDetail();
		float totalAmount = 0.0f;
		details.clear();
		for (int i = 0; i < arrrayBookId.length; i++) {
			int bookId = Integer.parseInt(arrrayBookId[i]);
			int quantity = Integer.parseInt(arrrayQuantity[i]);
			float price = Float.parseFloat(arrayPrice[i]);

			float subtotal = price * quantity;
			OrderDetail detail = new OrderDetail();
			detail.setBook(new Book(bookId));
			detail.setQuantity(quantity);
			detail.setSubtotal(subtotal);
			detail.setBookOrder(order);
			details.add(detail);
			totalAmount += subtotal;
		}
		order.setTotal(totalAmount);
		orderDAO.update(order);
		String message = "the order"+ order.getOrderId() + "has been update successfully";
		request.setAttribute("message", message);
		listOrder();
	}

	public void deleteOrder() throws ServletException, IOException {
		Integer orderId = Integer.parseInt(request.getParameter("id"));
		orderDAO.delete(orderId);
		
		String message = "the order ID" + orderId + "  has been deleted.";
		request.setAttribute("message", message);
		listOrder();
		
	}
}
