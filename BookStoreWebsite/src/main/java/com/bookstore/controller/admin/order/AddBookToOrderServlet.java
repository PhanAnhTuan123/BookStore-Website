package com.bookstore.controller.admin.order;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bookstore.controller.BaseServlet;
import com.bookstore.dao.BookDao;
import com.bookstore.entity.entity3.Book;
import com.bookstore.entity.entity3.BookOrder;
import com.bookstore.entity.entity3.OrderDetail;


@WebServlet("/admin/add_book_to_order")
public class AddBookToOrderServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
 
    public AddBookToOrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("bookId"));
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		BookDao bookDao = new BookDao(entityManager);
		Book book = bookDao.get(id);
		HttpSession session = request.getSession();
		BookOrder order =(BookOrder) session.getAttribute("order");
		float subtotal = (float) (quantity* book.getPrice());
		OrderDetail orderDetail = new OrderDetail();
		orderDetail.setBook(book);
		orderDetail.setQuantity(quantity);
		orderDetail.setSubtotal(subtotal);
		float newTotal = (float) (order.getTotal() + subtotal);
		order.setTotal(newTotal);
		request.setAttribute("book", book);
		request.setAttribute("NewBookPendingToAddToOrder", true);
		order.getDetail().add(orderDetail);
		String resultPage = "add_book_result.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(resultPage);
		dispatcher.forward(request, response);
	}

}
