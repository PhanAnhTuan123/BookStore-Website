package com.bookstore.controller.frontend;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.controller.BaseServlet;
import com.bookstore.dao.BookDao;
import com.bookstore.dao.CategoryDAO;
import com.bookstore.entity.entity3.Book;
import com.bookstore.entity.entity3.Category;


@WebServlet("")
public class HomeServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
    public HomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		CategoryDAO categoryDAO = new CategoryDAO(entityManager);
		BookDao bookDao = new BookDao(entityManager);
		List<Book>listNewBook = bookDao.listNewBook();
//		List<Category>listCategory = categoryDAO.listAll();
//		request.setAttribute("listCategory", listCategory);
		request.setAttribute("listNewBooks", listNewBook);
		
		String page = "/frontend/index.jsp";
		RequestDispatcher dispathcer = request.getRequestDispatcher(page);
		dispathcer.forward(request, response);
	}


}
