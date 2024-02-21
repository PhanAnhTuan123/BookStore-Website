package com.bookstore.service;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.dao.CustomerDAO;
import com.bookstore.entity.entity3.Customer;

public class CustomerServices {
	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;
	private HttpServletRequest request;
	private HttpServletResponse response;
	private CustomerDAO customerDao;
	public CustomerServices(EntityManager entityManager, HttpServletRequest request, HttpServletResponse response) {
		super();
		this.entityManager = entityManager;
		this.request = request;
		this.response = response;
		customerDao = new CustomerDAO(entityManager);
	}
	public void listCustomers() throws ServletException, IOException {
		List<Customer>listCustomer  = customerDao.listAll();
		request.setAttribute("listCustomer", listCustomer);
		String listPage = "customer_list.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(listPage);
		dispatcher.forward(request, response);
	}
	public void createCustomer() throws ServletException, IOException {
		String email = request.getParameter("email");
		Customer existsCustomer = customerDao.findByEmail(email);
		if(existsCustomer!=null) {
			String message = "Could not create customer: the email" + email+" is already registered by another customer."; 
			request.setAttribute("message", message);
		}else {
			String fullname = request.getParameter("fullName");
			String password = request.getParameter("fullName");
			String phone = request.getParameter("fullName");
			String address = request.getParameter("fullName");
			String city = request.getParameter("fullName");
			String zipCode = request.getParameter("fullName");
			String country = request.getParameter("country");
			
			Customer newCustomer = new Customer();
			newCustomer.setEmail(email);
			newCustomer.setFullname(fullname);
			newCustomer.setPassword(password);
			newCustomer.setPhone(phone);
			newCustomer.setAddresss(address);
			newCustomer.setcity(city);
			newCustomer.setcontry(country);
			newCustomer.setZipcode(zipCode);
			customerDao.create(newCustomer);
			String message = "New customer has been created successfully";
			request.setAttribute("message", message);
			listCustomers();
		}
		
	}
	
}
