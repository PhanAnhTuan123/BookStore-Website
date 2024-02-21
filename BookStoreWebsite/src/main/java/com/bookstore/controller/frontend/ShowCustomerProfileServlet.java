package com.bookstore.controller.frontend;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.controller.BaseServlet;
import com.bookstore.entity.entity3.Customer;
import com.bookstore.service.CustomerServices;

@WebServlet("/view_profile")
public class ShowCustomerProfileServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
    public ShowCustomerProfileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CustomerServices services = new CustomerServices(entityManager, request, response);
		services.showCustomerProfile();
	}

}
