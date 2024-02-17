package com.bookstore.controller.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.service.UsersServices;

@WebServlet("/admin/update_user")
public class UpdateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdateUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UsersServices services = new UsersServices(request, response);
		services.updateUser();
	}

}
