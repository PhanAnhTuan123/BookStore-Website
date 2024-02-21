package com.bookstore.controller.admin.customer;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.controller.BaseServlet;
import com.bookstore.service.CustomerServices;

@WebServlet("/edit_customer")
public class EditCustomerProfileServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
    public EditCustomerProfileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CustomerServices services = new CustomerServices(entityManager, request, response);
		services.showCustomerProfileEditForm();
	}

}
