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
      private static final String[] requiredURLs = {
    	"/view_profile","/edit_profile","/update_profile","/write_review","/checkout","/place_order"	  
      };
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
		String requestURL = httRequest.getRequestURL().toString();
		boolean logeedIn = session!=null && session.getAttribute("loggedCustomer") !=null;
		if(!logeedIn && isLoginRequired(requestURL)) {
			String queryString = httRequest.getQueryString();
			String redirectURL = requestURL;
			if(queryString !=null) {
				redirectURL = redirectURL.concat("?").concat(queryString);
			}
			
			session.setAttribute("redirectURL", requestURL);
			String loginPage = "frontend/login.jsp";
			RequestDispatcher dispatcher = httRequest.getRequestDispatcher(loginPage);
			dispatcher.forward(httRequest, response);
		}else {
			chain.doFilter(request, response);
		}
	}
	private boolean isLoginRequired(String requestURL) {
		for(String loginRequiredUDL : requiredURLs) {
			if(requestURL.contains(loginRequiredUDL)) {
				return true;
			}
		}
		return false;
	}
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
