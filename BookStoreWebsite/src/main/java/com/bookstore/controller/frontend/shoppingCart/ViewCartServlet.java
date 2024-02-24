package com.bookstore.controller.frontend.shoppingCart;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.controller.BaseServlet;
import com.bookstore.entity.entity3.Book;

/**
 * Servlet implementation class ViewCartServlet
 */
@WebServlet("/view_cart")
public class ViewCartServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	public ViewCartServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Object cartObject = request.getSession().getAttribute("cart");
		
		if(cartObject==null) {
			ShoppingCart cart = new ShoppingCart();
			request.getSession().setAttribute("cart", cart);
		}
//		Book
		
		String path = "frontend/shopping_cart.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);
	}

}
