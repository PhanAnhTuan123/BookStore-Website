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
 * Servlet implementation class AddBookToCartServlet
 */
@WebServlet("/add_to_cart")
public class AddBookToCartServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
    public AddBookToCartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer id = Integer.parseInt(request.getParameter("book_id"));
		Object cartObject = request.getSession().getAttribute("cart");
		ShoppingCart shoppingCart =null;
		if(cartObject !=null && cartObject instanceof ShoppingCart) {
			shoppingCart = (ShoppingCart) cartObject;
		}else {
			shoppingCart = new ShoppingCart();
			request.getSession().setAttribute("cart", shoppingCart);
		}
		BookDao bookDao = new BookDao(entityManager);
		Book book = bookDao.get(id);
		
		shoppingCart.addItem(book);
		String redirectURL = request.getContextPath().concat("view_cart");
		response.sendRedirect(redirectURL);
		
	}

}
