package com.bookstore.controller.admin.customer;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.controller.BaseServlet;
import com.bookstore.service.CustomerServices;

/**
 * Servlet implementation class DeleteCustomer
 */
@WebServlet("/admin/delete_customer")
public class DeleteCustomer extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
    
    public DeleteCustomer() {
        super();
        // TODO Auto-generated constructor stub
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	CustomerServices services = new CustomerServices(entityManager, req, resp);
    	
    	services.deleteCustomer();
    }

}
