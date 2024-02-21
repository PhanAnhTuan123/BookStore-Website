package com.bookstore.controller.admin.customer;

import com.bookstore.controller.BaseServlet;
import com.bookstore.service.CustomerServices;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EditCustomerServlet
 */
@WebServlet("/admin/edit_customer")
public class EditCustomerServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

    public EditCustomerServlet() {
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CustomerServices services = new CustomerServices(entityManager, request, response);
		services.editCustomer();
	}

}
