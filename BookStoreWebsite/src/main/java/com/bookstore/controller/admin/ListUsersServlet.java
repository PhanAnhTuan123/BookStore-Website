package com.bookstore.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.entity.entity3.Users;
import com.bookstore.service.UsersServices;

@WebServlet("/admin/user_list")
public class ListUsersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ListUsersServlet() {

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UsersServices usersServices = new UsersServices();
		List<Users>listUsers =  usersServices.listUser(request,response);
		
		for (Users users : listUsers) {
			System.out.println(users.toString());
		}
		request.setAttribute("listUsers", listUsers);
		String listpage = "user_list.jsp";
		
		RequestDispatcher dispatcher =  request.getRequestDispatcher(listpage);
		dispatcher.forward(request, response);
	}

}
