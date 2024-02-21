package com.bookstore.controller.frontend;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

/**
 * Servlet Filter implementation class CustomerLoginFilter
 */
@WebFilter("/*")
public class CustomerLoginFilter extends HttpFilter implements Filter {
      
    public CustomerLoginFilter() {
        super();
        // TODO Auto-generated constructor stub
    }

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		HttpServletRequest httRequest = (HttpServletRequest) request;
		HttpSession session = httRequest.getSession(false);
		String path = httRequest.getRequestURI().substring(httRequest.getContextPath().length());
		if(!path.startsWith("/admin/")) {
			chain.doFilter(httRequest, response);
			return;
		}
		boolean logeedIn = session!=null && session.getAttribute("loggedCustomer") !=null;
		if(!logeedIn && path.startsWith("view_profile")) {
			String loginPage = "frontend/login.jsp";
			RequestDispatcher dispatcher = httRequest.getRequestDispatcher(loginPage);
			dispatcher.forward(httRequest, response);
		}else {
			chain.doFilter(request, response);
		}
	}
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
