package com.bookstore.controller.admin.order;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.controller.BaseServlet;
import com.bookstore.service.OrderServices;

/**
 * Servlet implementation class ListOrderServlet
 */
@WebServlet("/admin/list_orders")
public class ListOrderServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	public ListOrderServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		OrderServices services = new OrderServices(entityManager, request, response);
		services.listOrder();
	}

}
