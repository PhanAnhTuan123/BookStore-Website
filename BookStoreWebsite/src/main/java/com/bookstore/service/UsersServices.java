package com.bookstore.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

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


	public List<Users> listUser() {
		 List<Users>listUsers =  userDao.listAll();
		return  listUsers;
	}
}
