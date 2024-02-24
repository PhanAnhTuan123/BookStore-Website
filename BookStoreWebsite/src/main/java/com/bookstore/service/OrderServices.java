package com.bookstore.service;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.dao.CustomerDAO;
import com.bookstore.dao.OrderDAO;
import com.bookstore.entity.entity3.BookOrder;

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
		List<BookOrder>listOrder = orderDAO.listAll();
		request.setAttribute("listOrder", listOrder);
		String listPage = "order_list.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(listPage);
		dispatcher.forward(request, response);
	}
	public void viewOrderDetailForAdmin() throws ServletException, IOException {
	
		int orderId = Integer.parseInt(request.getParameter("id"));
		BookOrder order =orderDAO.get(orderId);
		request.setAttribute("order", order);
		String detailPage = "order_detail.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(detailPage);
		dispatcher.forward(request, response);
	
	}
	public void showCheckoutForm() throws ServletException, IOException {
		String checkoutPage = "checkout.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(checkoutPage);
		dispatcher.forward(request, response);
	}
}
