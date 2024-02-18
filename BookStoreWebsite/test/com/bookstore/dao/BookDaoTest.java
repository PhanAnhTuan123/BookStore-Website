package com.bookstore.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.util.Date;

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

		byte[] imageBytes =  Files.readAllBytes(Paths.get(imagePath));
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

		byte[] imageBytes =  Files.readAllBytes(Paths.get(imagePath));
		book.setImage(imageBytes);
		book.setPrice(40.4);
		book.setPublish_date(new Date());
		book.setLast_update_time(new Timestamp(2));
		Category cate = new Category("Chinh Tri");
		cate.setCategoryId(2);
		book.setCategory(cate);
		Book bookUpdate = bookDao.update(book);
//		assertTrue(bookCreated.getBookID() > 0);
		assertEquals(existBook.getCategory().getCategoryId(),bookUpdate.getCategory().getCategoryId());
	}
	

	
	
}
