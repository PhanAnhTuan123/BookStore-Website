package com.bookstore.controller.admin;

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
import com.bookstore.dao.CustomerDAO;
import com.bookstore.dao.OrderDAO;
import com.bookstore.dao.ReviewDAO;
import com.bookstore.dao.UserDAO;
import com.bookstore.entity.entity3.BookOrder;
import com.bookstore.entity.entity3.Review;


@WebServlet("/admin/")
public class AdminHomeServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

    public AdminHomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OrderDAO orderDao = new OrderDAO(entityManager);
		ReviewDAO reviewda = new ReviewDAO(entityManager);
		UserDAO userdao = new UserDAO(entityManager);
		BookDao bookDao = new BookDao(entityManager);
		CustomerDAO customerDAo = new CustomerDAO(entityManager);
		
		long totalUsers = userdao.count();
		long totalBooks = bookDao.count();
		long totalCustomer = customerDAo.count();
		long totalReview = reviewda.count();
		long totalOrder = orderDao.count();
		List<BookOrder>listMostRecentSales = orderDao.listMostRecentSales();
		
		List<Review>listMostRecentReviews = reviewda.listMostRecent();
		request.setAttribute("listMostRecentSales", listMostRecentSales);
		request.setAttribute("listMostRecemtReviews", listMostRecentReviews);
		request.setAttribute("totalUsers", totalUsers);
		request.setAttribute("totalBooks", totalBooks);
		request.setAttribute("totalCustomer", totalCustomer);
		
		request.setAttribute("totalReview", totalReview);
		request.setAttribute("totalOrder", totalOrder);
		
		String page = "index.jsp";
		RequestDispatcher dispathcer = request.getRequestDispatcher(page);
		dispathcer.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doGet(req, resp);
	}


}
