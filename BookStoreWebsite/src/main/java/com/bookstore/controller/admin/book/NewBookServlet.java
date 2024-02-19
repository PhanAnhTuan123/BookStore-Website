package com.bookstore.controller.admin.book;

import com.bookstore.controller.BaseServlet;
import com.bookstore.service.BookServices;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NewBookServlet
 */
@WebServlet("/admin/new_book")
public class NewBookServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

 
    public NewBookServlet() {
    	
  }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookServices services = new BookServices(entityManager, request, response);
		services.ShowBookNewForm();
	}

}
