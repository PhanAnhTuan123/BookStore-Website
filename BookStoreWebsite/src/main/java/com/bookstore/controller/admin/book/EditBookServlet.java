package com.bookstore.controller.admin.book;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.controller.BaseServlet;
import com.bookstore.service.BookServices;

/**
 * Servlet implementation class EditBookServlet
 */
@WebServlet("/admin/edit_book")
public class EditBookServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	public EditBookServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BookServices services = new BookServices(entityManager, request, response);
		services.editBook();
	}

}
