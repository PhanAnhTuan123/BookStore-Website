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
		String message = "Create category is successfully.";
		request.setAttribute("message",message);
		RequestDispatcher dispatcher = request.getRequestDispatcher(listPage);
		dispatcher.forward(request, response);

	}
	public void createCategory() throws ServletException, IOException {
		String name = request.getParameter("name");
		Category existCategory = categoryDAO.findByName(name);
		if(existCategory!=null) {
			String message = "Could not create category. A category with name + " + name + " is exists.";
			request.setAttribute("message",message);
			RequestDispatcher dispatcher = request.getRequestDispatcher("message.jsp");
			dispatcher.forward(request, response);
		}else {
			Category newCategory = new Category(name);
			categoryDAO.create(newCategory);
			listCategory();
		}
	}
	public void editCategory() throws ServletException, IOException {
		Integer categoryId = Integer.parseInt(request.getParameter("id"));
		Category category = categoryDAO.get(categoryId);
		request.setAttribute("category", category);
		String editPage  = "category_form.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher("message.jsp");
		dispatcher.forward(request, response);
		
	}

	public void updateCategory() throws ServletException, IOException {
		Integer categoryId = Integer.parseInt(request.getParameter("categoryId"));
		String categoryName = request.getParameter("name");
		Category categorybyId = categoryDAO.get(categoryId);
		Category categorybyNane = categoryDAO.findByName(categoryName);
		if(categorybyNane!=null && categorybyId.getCategoryId()!=categorybyNane.getCategoryId()) {
			String message = "Could not update category." + " A category with name" + categoryName + " already exists.";
			request.setAttribute("message", message);
			RequestDispatcher dispatcher = request.getRequestDispatcher("message.jsp");
			dispatcher.forward(request, response);
		}else {
			categorybyId.setName(categoryName);
			categoryDAO.update(categorybyId);
			String message = "Category has been updated successfully";
			request.setAttribute("message", message);
			listCategory();
		}
	}

}
