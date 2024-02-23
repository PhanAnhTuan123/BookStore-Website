package com.bookstore.controller.frontend.shoppingCart;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.controller.BaseServlet;
import com.bookstore.dao.BookDao;
import com.bookstore.entity.entity3.Book;

/**
 * Servlet implementation class RemoveBookFromCartServlet
 */
@WebServlet("/remove_from_cart")
public class RemoveBookFromCartServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
       

    public RemoveBookFromCartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer id = Integer.parseInt(request.getParameter("book_id"));
		Object cartObject = request.getSession().getAttribute("cart");
		ShoppingCart shoppingCart = (ShoppingCart) cartObject;
		BookDao bookDao = new BookDao(entityManager);
//		Book book = bookDao.get(id);
		
		shoppingCart.removeItem(new Book(id));
		String redirectURL = request.getContextPath().concat("view_cart");
		response.sendRedirect(redirectURL);
	}



}
