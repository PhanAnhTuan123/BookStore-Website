package com.bookstore.service;

import java.io.IOException;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
//import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.dao.UserDAO;
import com.bookstore.entity.entity3.Users;

public class UsersServices {
	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;
	private UserDAO userDao;
	private HttpServletRequest request;
	private HttpServletResponse response;

	public UsersServices(HttpServletRequest request, HttpServletResponse response) {
		super();
		this.request = request;
		this.response = response;
	}

	public UsersServices() {

		entityManagerFactory = Persistence.createEntityManagerFactory("BookStoreWebsite");
		entityManager = entityManagerFactory.createEntityManager();
		userDao = new UserDAO(entityManager);
	}

	public List<Users> listUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Users> listUsers = userDao.listAll();
		request.setAttribute("listUsers", listUsers);

		String listPage = "user_list.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(listPage);
		dispatcher.forward(request, response);
		return listUsers;
	}

	public void createUser(String email, String fullname, String password) {
		Users existUser = userDao.findByEmail(email);
		if (existUser != null) {
			return;
		} else {
			Users newUser = new Users(email, password, fullname);
			userDao.create(newUser);
		}

	}

	public void editUser() throws ServletException, IOException {
		Integer userId = Integer.parseInt(request.getParameter("id"));
		Users user = userDao.get(userId);
		String editPage = "user_form.jsp";
		request.setAttribute("user", user);
		RequestDispatcher dispatcher = request.getRequestDispatcher(editPage);
		dispatcher.forward(request, response);
	}

	public void updateUser() throws ServletException, IOException {
		Integer userId = Integer.parseInt(request.getParameter("userID"));
		String email = request.getParameter("email");
		String fullname = request.getParameter("fullname");
		String password = request.getParameter("password");
		Users userById = userDao.get(userId);
		Users userByEmail = userDao.findByEmail(email);
		if (userByEmail != null && userByEmail.getUserId() != userById.getUserId()) {
			String message = "Could not update user.";
			request.setAttribute("message", message);
			RequestDispatcher dispatcher = request.getRequestDispatcher("message.jsp");
			dispatcher.forward(request, response);
		} else {
			Users user = new Users(email, password, fullname);
			userDao.update(user);
			String message = "Users has been updated successfully";
			request.setAttribute("message", message);
			listUser(request, response);
		}

	}
}
