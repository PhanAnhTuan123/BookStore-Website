package com.bookstore.controller.admin.order;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.controller.BaseServlet;
import com.bookstore.service.OrderServices;

@WebServlet("/admin/update_order")
public class UpdateOrderServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	public UpdateOrderServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	OrderServices orderServices = new OrderServices(entityManager, request, response);
	orderServices.updateOrder();
	
	}

}
