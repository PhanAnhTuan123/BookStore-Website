package com.bookstore.controller.frontend.order;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.controller.BaseServlet;
import com.bookstore.service.OrderServices;


@WebServlet("/show_order_detail")
public class ShowOrderDetailServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
       

    public ShowOrderDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OrderServices services = new OrderServices(entityManager, request, response);
		services.showOrderDetailFOrCustomer();
	}


}
