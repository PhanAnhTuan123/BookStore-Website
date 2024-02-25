package com.bookstore.dao;

import static org.junit.Assert.*;

import java.util.List;

import javax.persistence.Persistence;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.bookstore.entity.entity3.Book;
import com.bookstore.entity.entity3.Customer;
import com.bookstore.entity.entity3.Review;

public class ReviewDAOTest extends BaseDAOTest{
	private static ReviewDAO reviewDao;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		entityManagerFactory = Persistence.createEntityManagerFactory("BookStoreWebsite");
		entityManager = entityManagerFactory.createEntityManager();
		reviewDao  = new ReviewDAO(entityManager);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
//		entityManager.close();
//		entityManagerFactory.close();
		reviewDao.close();
	}

	@Test
	public void testCreateReview() {
		Review review = new Review();
		Book book = new Book();
		book.setBookID(1);
		Customer customer = new Customer();
		customer.setCustomerId(1);
		review.setBook(book);
		review.setCustomer(customer);
		review.setHeadline("This is a very good book.");
		review.setFating(5);
		review.setComment("I have just read this book. Very very good.!");
		
		Review savedReview = reviewDao.create(review);
		assertNotNull(savedReview);
	}
	@Test
	public void testGet() {
		Integer id = 1;
		Review review = reviewDao.get(id);
		assertNotNull(review);
	}
	@Test
	public void testUpdateReview() {
		Integer id = 1;
		Review review = reviewDao.get(id);
		review.setHeadline("Excellent book");
		Review updatedReview = 	reviewDao.update(review);
		assertEquals(review.getHeadline(), updatedReview.getHeadline());
	}
	@Test
	public void testListAll() {
		List<Review>listReview = reviewDao.listAll();
		listReview.forEach(c->System.out.println(c.toString()));
		assertTrue(!listReview.isEmpty());
	}
	@Test
	public void testCount() {
		long totalReviews = reviewDao.count();
		assertTrue(totalReviews > 0);
	}
	@Test
	public void testDelete() {
		int id = 2;
		reviewDao.delete(id);
		Review review = reviewDao.get(id);
		assertNull(review);
	}
	@Test
	public void testFindByCustomerandBookNotfound() {
		Integer customerId = 1;
		Integer bookId = 99;
		Review result = reviewDao.findByCustomerAndBook(customerId, bookId);
		assertNull(result);
	}
	@Test
	public void testFindByCustomerandBookSuccess() {
		Integer customerId = 1;
		Integer bookId = 7;
		Review result = reviewDao.findByCustomerAndBook(customerId, bookId);
		assertNull(result);
	}
	@Test
	public void testListMostRecent() {
		List<Review>recentReviews = reviewDao.listMostRecent();
		assertEquals(3, recentReviews.size());
	}
	
}
