package com.bookstore.controller.frontend.order;

import com.bookstore.controller.BaseServlet;
import com.bookstore.service.OrderServices;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/place_order")
public class PlaceOrderServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	public PlaceOrderServlet() {
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		OrderServices services = new OrderServices(entityManager, request, response);
		services.placeOrder();
	}

}
