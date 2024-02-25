package com.bookstore.controller.admin.order;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bookstore.controller.BaseServlet;
import com.bookstore.entity.entity3.BookOrder;
import com.bookstore.entity.entity3.OrderDetail;

@WebServlet("/admin/remove_book_from_order")
public class RemoveBookFormOrderServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	public RemoveBookFormOrderServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int bookId = Integer.parseInt(request.getParameter("id"));
		HttpSession session = request.getSession();
		BookOrder order = (BookOrder) session.getAttribute("order");

		Set<OrderDetail> details = (Set<OrderDetail>) order.getDetail();
		Iterator<OrderDetail> iterator = details.iterator();
		while (iterator.hasNext()) {
			OrderDetail orderDetail = iterator.next();
			if (orderDetail.getBook().getBookID() == bookId) {
				float newTotal = (float) (order.getTotal() - orderDetail.getSubtotal());
				order.setTotal(newTotal);
				iterator.remove();
			}
		}
		String editOrderFormPage = "order_form.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(editOrderFormPage);
		dispatcher.forward(request, response);
	}

}
