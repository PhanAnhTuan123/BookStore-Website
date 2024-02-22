package com.bookstore.service;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.dao.CustomerDAO;
import com.bookstore.dao.ReviewDAO;
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
		List<Review>listReviews = reviewDAO.listAll();
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
		String message=  "The review has been deleted successfully";
		request.setAttribute("message", message);
		listAllReview();
	}
	public void showReviewForm() throws ServletException, IOException {
		String targetPage = "frontend/review_form.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(targetPage);
		dispatcher.forward(request, response);
	}
	
}
