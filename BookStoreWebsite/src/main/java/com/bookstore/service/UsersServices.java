package com.bookstore.service;

import java.io.IOException;
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
	
	
	public UsersServices() {

		entityManagerFactory = Persistence.createEntityManagerFactory("BookStoreWebsite");
		entityManager = entityManagerFactory.createEntityManager();
		userDao = new UserDAO(entityManager);
	}
	public List<Users> listUser(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		 List<Users>listUsers =  userDao.listAll();
		 request.setAttribute("listUsers", listUsers);
		
		 
		 String listPage = "user_list.jsp";
		 RequestDispatcher dispatcher = request.getRequestDispatcher(listPage);
		 dispatcher.forward(request, response);
		return  listUsers;
	}
	public void createUser(String email,String fullname,String password) {
		Users existUser = userDao.findByEmail(email);
		if(existUser!=null) {
			return;
		}else {
		Users newUser  = new Users(email, password, fullname);
		userDao.create(newUser);
		}
		
	}
}
