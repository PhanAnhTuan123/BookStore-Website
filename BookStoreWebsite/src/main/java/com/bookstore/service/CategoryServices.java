package com.bookstore.service;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.dao.CategoryDAO;
import com.bookstore.entity.entity3.Category;

public class CategoryServices {
	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;
	private CategoryDAO categoryDAO;
	private HttpServletRequest request;
	private HttpServletResponse response;

	public CategoryServices(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;

//		entityManagerFactory = Persistence.createEntityManagerFactory("BookStoreWebsite");
//		entityManager = entityManagerFactory.createEntityManager();
		categoryDAO = new CategoryDAO(entityManager);
	}

	public CategoryServices(EntityManagerFactory entityManagerFactory, EntityManager entityManager,
			HttpServletRequest request, HttpServletResponse response) {

		this.entityManagerFactory = entityManagerFactory;
		this.entityManager = entityManager;
		this.request = request;
		this.response = response;
		categoryDAO = new CategoryDAO(entityManager);
	}

	public void listCategory() throws ServletException, IOException {
		List<Category> listCategory = categoryDAO.listAll();
		request.setAttribute("listCategory", listCategory);
		String listPage = "category_list.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(listPage);
		dispatcher.forward(request, response);

	}

}
