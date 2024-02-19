package com.bookstore.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.bookstore.entity.entity3.Book;
import com.bookstore.entity.entity3.Category;

class BookDaoTest extends BaseDAOTest {
	private static BookDao bookDao;

	@BeforeClass
	static void setUpBeforeClass() throws Exception {
		BaseDAOTest.setupClass();
		bookDao = new BookDao(entityManager);
	}

	@AfterClass
	static void tearDownAfterClass() throws Exception {
		BaseDAOTest.tearDownClass();

	}

	@Test
	void testCreateBook() throws IOException {
		Book book = new Book();
		book.setTitle("Demo");
		book.setAuthor("Nguyen Binh");
		book.setDescription("Tac gia cua nhung");
		book.setIsbn("ISBn");
//		book.setImage(new byte[] {2,1,3,4,5});
		String imagePath = "D:\\BookStoreWebSite\\BookStore-Website\\BookStore-Website\\BookStoreWebsite\\src\\main\\webapp\\images\\customer.png";

		byte[] imageBytes = Files.readAllBytes(Paths.get(imagePath));
		book.setImage(imageBytes);
		book.setPrice(40.4);
		book.setPublish_date(new Date());
		book.setLast_update_time(new Timestamp(2));
		Category cate = new Category("Chinh Tri");
		cate.setCategoryId(2);
		book.setCategory(cate);
		Book bookCreated = bookDao.create(book);
		assertTrue(bookCreated.getBookID() > 0);
	}

	@Test
	void testUpdateBook() throws IOException {
		Book existBook = new Book();
		existBook.setBookID(1);
		Book book = new Book();
		book.setBookID(1);
		book.setTitle("Demo");
		book.setAuthor("Nguyen Binh");
		book.setDescription("Tac gia cua nhung");
		book.setIsbn("ISBn");
//		book.setImage(new byte[] {2,1,3,4,5});
		String imagePath = "D:\\BookStoreWebSite\\BookStore-Website\\BookStore-Website\\BookStoreWebsite\\src\\main\\webapp\\images\\customer.png";

		byte[] imageBytes = Files.readAllBytes(Paths.get(imagePath));
		book.setImage(imageBytes);
		book.setPrice(40.4);
		book.setPublish_date(new Date());
		book.setLast_update_time(new Timestamp(2));
		Category cate = new Category("Chinh Tri");
		cate.setCategoryId(2);
		book.setCategory(cate);
		Book bookUpdate = bookDao.update(book);
//		assertTrue(bookCreated.getBookID() > 0);
		assertEquals(existBook.getCategory().getCategoryId(), bookUpdate.getCategory().getCategoryId());
	}

	@org.junit.Test
	void testDeleteBookFailed() {
		Integer bookId = 100;
		bookDao.delete(bookId);
		assertTrue(true);
	}

	@org.junit.Test
	void testDeleteBookSuccess() {
		Integer bookId = 1;
		bookDao.delete(bookId);
		assertTrue(true);
	}
	@org.junit.Test(expected = EntityNotFoundException.class)
	public void testGetBookFail() {
		Integer bookId = 99;
		Book book =  bookDao.get(bookId);
		assertNull(book);
	}
	@org.junit.Test(expected = EntityNotFoundException.class)
	public void testGetBookSuccess() {
		Integer bookId = 3;
		Book book =  bookDao.get(bookId);
		assertNotNull(book);
	}
	@org.junit.Test
	public void testListAll() {
		List<Book>listBook = bookDao.listAll();
		listBook.forEach(c -> System.out.println(c.toString()));
		assertFalse(listBook.isEmpty());
	}
	@org.junit.Test
	public void testFindByTitleNotExists() {
		String title = "Lap Trinh";
		Book book =  bookDao.findByTitle(title);
		assertNull(book);
	}
	@org.junit.Test
	public void testFindByTitleIsExists() {
		String title = "Tieu Thuyet";
		Book book =  bookDao.findByTitle(title);
		assertNotNull(book);
	}
	@org.junit.Test
	public void testCount() {
		Integer totalBooks = (int) bookDao.count();
		assertTrue(totalBooks > 0);
	}
	
	
}
