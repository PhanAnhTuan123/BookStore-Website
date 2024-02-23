package com.bookstore.service;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bookstore.dao.BookDao;
import com.bookstore.dao.CustomerDAO;
import com.bookstore.dao.ReviewDAO;
import com.bookstore.entity.entity3.Book;
import com.bookstore.entity.entity3.Customer;
import com.bookstore.entity.entity3.Review;

public class ReviewServices {
	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;
	private HttpServletRequest request;
	private HttpServletResponse response;
	private ReviewDAO reviewDAO;

	public ReviewServices(EntityManager entityManager, HttpServletRequest request, HttpServletResponse response) {

		this.entityManager = entityManager;
		this.request = request;
		this.response = response;
		reviewDAO = new ReviewDAO(entityManager);
	}

	public void listAllReview() throws ServletException, IOException {
		List<Review> listReviews = reviewDAO.listAll();
		request.setAttribute("listReviews", listReviews);
		String listPage = "review_list.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(listPage);
		dispatcher.forward(request, response);
	}

	public void editReview() throws ServletException, IOException {
		Integer id = Integer.parseInt(request.getParameter("id"));
		Review review = reviewDAO.get(id);
		request.setAttribute("review", review);

		String editPage = "review_form.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(editPage);
		dispatcher.forward(request, response);

	}

	public void updateReview() throws ServletException, IOException {
		Integer id = Integer.parseInt(request.getParameter("id"));
		String headline = request.getParameter("headline");
		String comment = request.getParameter("comment");
		Review review = reviewDAO.get(id);
		review.setComment(comment);
		review.setHeadline(headline);
		String message = "The review has been  updated successfully";
		request.setAttribute("message", message);
		listAllReview();

	}

	public void deleteReviews() throws ServletException, IOException {
		Integer id = Integer.parseInt(request.getParameter("id"));
		reviewDAO.delete(id);
		String message = "The review has been deleted successfully";
		request.setAttribute("message", message);
		listAllReview();
	}

	public void showReviewForm() throws ServletException, IOException {
		Integer bookId = Integer.parseInt(request.getParameter("book_id"));
		BookDao bookdao = new BookDao(entityManager);
		Book book = bookdao.get(bookId);
		request.setAttribute("book", book);
		request.getSession().setAttribute("book", book);
		HttpSession session = request.getSession();
		Customer customer = (Customer) session.getAttribute("loggedCustomer");
		Review existsReview = reviewDAO.findByCustomerAndBook(customer.getCustomerId(), bookId);
		if (existsReview != null) {
			request.setAttribute("review", existsReview);
			String targetPage = "frontend/review_info.jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(targetPage);
			dispatcher.forward(request, response);
		} else {

			String targetPage = "frontend/review_form.jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(targetPage);
			dispatcher.forward(request, response);
		}
	}

	public void submitReview() throws ServletException, IOException {
		Integer bookId = Integer.parseInt(request.getParameter("bookId"));
		float rating = Float.parseFloat(request.getParameter("rating"));
		String headline = request.getParameter("headline");
		String comment = request.getParameter("comment");
		Review newReview = new Review();
		newReview.setHeadline(headline);
		newReview.setComment(comment);
		newReview.setComment(comment);
		newReview.setFating((int) rating);

		Book book = new Book();
		book.setBookID(bookId);
		newReview.setBook(book);
		Customer customer = (Customer) request.getSession().getAttribute("loggedCustomer");
		newReview.setCustomer(customer);
		reviewDAO.create(newReview);

		String messagePage = "frontend/review_done.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(messagePage);
		dispatcher.forward(request, response);

	}

}
