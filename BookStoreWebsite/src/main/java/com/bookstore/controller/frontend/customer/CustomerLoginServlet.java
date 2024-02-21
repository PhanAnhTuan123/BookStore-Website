package com.bookstore.controller.frontend.customer;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.controller.BaseServlet;
import com.bookstore.service.CustomerServices;

/**
 * Servlet implementation class CustomerLoginServlet
 */
@WebServlet("/login")
public class CustomerLoginServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
    public CustomerLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		CustomerServices services = new CustomerServices(entityManager, request, response);
		services.showLogin();
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CustomerServices services = new CustomerServices(entityManager, request, response);
		services.doLogin();
	}

}
