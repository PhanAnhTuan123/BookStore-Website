package com.bookstore.controller.admin.book;

import com.bookstore.controller.BaseServlet;
import com.bookstore.service.BookServices;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateBookServlet
 */
@WebServlet("/admin/update_book")
@MultipartConfig(
		fileSizeThreshold = 1024 *  10, //10 KB
		maxFileSize = 1024*300, //300KB
		maxRequestSize = 1024*1024 //1MB
)
public class UpdateBookServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public UpdateBookServlet() {
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookServices services = new BookServices(entityManager, request, response);
		try {
			services.updateBook();
		} catch (IOException | ServletException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
