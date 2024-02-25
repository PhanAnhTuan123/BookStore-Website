package com.bookstore.controller.admin.order;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.controller.BaseServlet;
import com.bookstore.service.OrderServices;

@WebServlet("/admin/delete_order")
public class DeleteOrderServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	public DeleteOrderServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		OrderServices orderServices = new OrderServices(entityManager, request, response);
		orderServices.deleteOrder();
	}

}
