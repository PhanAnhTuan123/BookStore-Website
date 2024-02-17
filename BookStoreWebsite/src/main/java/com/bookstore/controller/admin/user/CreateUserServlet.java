package com.bookstore.controller.admin.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.service.UsersServices;

/**
 * Servlet implementation class CreateUserServlet
 */
@WebServlet("/admin/create_user")
public class CreateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String fullname = request.getParameter("fullname");
		String password = request.getParameter("password");
		UsersServices services = new UsersServices();
		services.createUser(email,password,fullname);
		request.setAttribute("message", "New user created successfully");
		services.listUser(request,response);
		
	}

}
