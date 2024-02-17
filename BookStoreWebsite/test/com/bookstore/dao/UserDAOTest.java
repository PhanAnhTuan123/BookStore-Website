package com.bookstore.dao;

import static org.junit.Assert.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.bookstore.entity.entity3.*;


public class UserDAOTest extends BaseDAOTest{

	private static UserDAO userDao;
	
	@BeforeClass
	public static void setupClass() {
		entityManagerFactory = Persistence.createEntityManagerFactory("BookStoreWebsite");
		entityManager = entityManagerFactory.createEntityManager();
		userDao = new UserDAO(entityManager);
	}
	
	@Test
	public void testCreateUsers() {
		com.bookstore.entity.entity3.Users user1 = new com.bookstore.entity.entity3.Users();
		user1.setEmail("tommy@gmail.com");
		user1.setFullName("Tommy Timothy");
		user1.setPassword("abcsd");
		
		UserDAO userDao =new UserDAO(entityManager);
		user1 = userDao.create(user1);
	
		assertTrue(user1.getUserId() > 0);
	}
	@Test(expected = PersistenceException.class)
	public void testCreateUsersFieldsNotSet() {
		com.bookstore.entity.entity3.Users user1 = new com.bookstore.entity.entity3.Users();		
		
		user1 = userDao.create(user1);
	
//		assertTrue(user1.getUserId() > 0);
	}
	@Test
	public void testUpdateUsers() {
		com.bookstore.entity.entity3.Users user = new com.bookstore.entity.entity3.Users();
		user.setUserId(5);  
		user.setEmail("tuan@codejava.net");
		user.setFullName("phan Anh Tuan");
		user.setPassword("tuan sercret");
		
		user = userDao.update(user);
		String expected = "tuan sercret";
		String actual = user.getPassword();
		assertEquals(expected,actual);
	}
	@Test
	public void testGetUsersFound() {
		Integer userId = 5;
		com.bookstore.entity.entity3.Users user= userDao.get(userId);
		System.out.println(user.getEmail());
		assertNotNull(user);
		
	}
	@Test
	public void testGetUsersNotFound() {
		Integer userId = 99;
		Users user = userDao.get(userId);
		assertNull(user);
	}
	@Test
	public void testDeleteUsers() {
		Integer userId = 10;
		userDao.delete(userId);
		
		Users user = userDao.get(userId);
		
		assertNull(user);
	}
	@Test(expected = EntityNotFoundException.class)
	public void testDeleteNonExistUsers() {
		Integer userId = 55;
		userDao.delete(userId);
	}
	@Test
	public void testListAll() {
		List<Users>listUsers = userDao.listAll();
//		System.out.println(listUsers.size());
		for (Users users : listUsers) {
			System.out.println(users.getEmail());
		}
		assertTrue(listUsers.size() > 0);
	}
	@Test
	public void testFindByEmail() {
		String email = "tuan@gmail.com";
		Users user = userDao.findByEmail(email);
		assertNull(user);
	}
	@Test
	public void testCount() {
		long totalUsers  = userDao.count();
		assertTrue(totalUsers  == 7);
	}

	@AfterClass
	public static void tearDownClass() {
		entityManager.close();
		entityManagerFactory.close();
	}
}
