package com.bookstore.service;

import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.bookstore.dao.BookDao;
import com.bookstore.dao.CategoryDAO;
import com.bookstore.entity.entity3.Book;
import com.bookstore.entity.entity3.Category;

public class BookServices {
	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;
	private HttpServletRequest request;
	private HttpServletResponse response;
	private BookDao bookDao;
	private CategoryDAO category;

	public BookServices(EntityManager entityManager, HttpServletRequest request, HttpServletResponse response) {
		super();
		this.entityManager = entityManager;
		this.request = request;
		this.response = response;
		bookDao = new BookDao(entityManager);
		category = new CategoryDAO(entityManager);
	}

	public void listBook() throws ServletException, IOException {
		List<Book> listbook = bookDao.listAll();
		request.setAttribute("listBook", listbook);
		String listPage = "book_list.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(listPage);
		dispatcher.forward(request, response);
	}

	public void ShowBookNewForm() throws ServletException, IOException {
		List<Category> listCategory = category.listAll();
		request.setAttribute("listCategory", listCategory);
		String newPage = "book_form.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(newPage);
		dispatcher.forward(request, response);
	}

	public void createBook() throws ParseException, IOException, ServletException {
		Integer categoryId = Integer.parseInt(request.getParameter("category"));
		String title = request.getParameter("title");
		Book existsBoook = bookDao.findByTitle(title);
		if (existsBoook != null) {
			String message = "Could not create new book because the title " + title + " already exists.";
			request.setAttribute("message", message);
			listBook();
			return;
		}
		String author = request.getParameter("author");
		String description = request.getParameter("description");
		String isbn = request.getParameter("isbn");
		float price = Float.parseFloat(request.getParameter("price"));
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date publishDate = dateFormat.parse(request.getParameter("publistDate"));

		Book book = new Book();
		Part part = request.getPart("bookImage");
		if (part != null && part.getSize() > 0) {
			long size = part.getSize();
			byte[] imageBytes = new byte[(int) size];
			InputStream inputStream = part.getInputStream();
			inputStream.read(imageBytes);
			inputStream.close();
			book.setImage(imageBytes);
		}

		book.setTitle(title);
		book.setAuthor(author);
		book.setDescription(description);
		book.setIsbn(isbn);
		book.setPublish_date(publishDate);
		book.setPrice(price);
		Category cate = category.get(categoryId);
		book.setCategory(cate);

		Book createBook = bookDao.create(book);
		if (createBook.getBookID() > 0) {
			String message = "A new book has been create successfully";
			request.setAttribute("message", message);
			listBook();
		}
	}

	public void editBook() throws ServletException, IOException {
		Integer bookId = Integer.parseInt(request.getParameter("id"));
		Book book = bookDao.get(bookId);
		List<Category> listCategory = category.listAll();
		request.setAttribute("book", book);
		request.setAttribute("listCategory", listCategory);
		String newPage = "book_form.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(newPage);
		dispatcher.forward(request, response);
	}
	public void readBookField(Book book) throws IOException, ServletException, ParseException {
		Integer categoryId = Integer.parseInt(request.getParameter("category"));
		String title = request.getParameter("title");
		Book existsBoook = bookDao.findByTitle(title);
		if (existsBoook != null) {
			String message = "Could not create new book because the title " + title + " already exists.";
			request.setAttribute("message", message);
			listBook();
			return;
		}
		String author = request.getParameter("author");
		String description = request.getParameter("description");
		String isbn = request.getParameter("isbn");
		float price = Float.parseFloat(request.getParameter("price"));
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date publishDate = dateFormat.parse(request.getParameter("publistDate"));

		Part part = request.getPart("bookImage");
		if (part != null && part.getSize() > 0) {
			long size = part.getSize();
			byte[] imageBytes = new byte[(int) size];
			InputStream inputStream = part.getInputStream();
			inputStream.read(imageBytes);
			inputStream.close();
			book.setImage(imageBytes);
		}
		book.setTitle(title);
		book.setAuthor(author);
		book.setDescription(description);
		book.setIsbn(isbn);
		book.setPublish_date(publishDate);
		book.setPrice(price);
		Category cate = category.get(categoryId);
		book.setCategory(cate);
		
		
	}
	public void updateBook() throws IOException, ServletException, ParseException {
		Integer bookId = Integer.parseInt(request.getParameter("id"));
		Book existsBook  = bookDao.get(bookId);
		String title = request.getParameter("title");
		Book  bookByTitle = bookDao.findByTitle(title);
		if(!existsBook.equals(bookByTitle)) {
			String message = "Could not update book because there's another book having same title.";
			request.setAttribute("message", message);
			listBook();
			return;
		}
		readBookField(existsBook);
		bookDao.update(existsBook);
		String message = "The book has been updated successfully";
		request.setAttribute("message", message);
		
		
		
	}

	public void deleteBook() throws ServletException, IOException {
		Integer bookId = Integer.parseInt(request.getParameter("id"));
		bookDao.delete(bookId);
		String message = "The book has been deleted successfully.";
		request.setAttribute("message", message);
		listBook();
	}

	public void listBooksByCategory() throws ServletException, IOException {
		int categoryId = Integer.parseInt(request.getParameter("id"));
		List<Book>listBooks = bookDao.listByCategory(categoryId);
		Category category2 = category.get(listBooks);
		List<Category>listCategory = category.listAll();
		request.setAttribute("listCategory", listCategory);
		request.setAttribute("category", category2);
		request.setAttribute("listBooks", listBooks);
		String listPage = "frontend/book_list_by_category.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(listPage);
		dispatcher.forward(request, response);
	}

	public void viewBookDetail() throws ServletException, IOException {
		Integer bookId = Integer.parseInt(request.getParameter("id"));
		Book book = bookDao.get(bookId);
		request.setAttribute("book", book);
//		Category cate = category.get(categoryId);
		List<Category>listCategory = category.listAll();
		request.setAttribute("listCategory", listCategory);
		String detailPage = "/frontend/book_detail.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(detailPage);
		dispatcher.forward(request, response);
	}

	public void search() throws ServletException, IOException {
		String keyword = request.getParameter("keyword");
		List<Book>result = null;
		if(keyword.equals("")) {
			result = bookDao.listAll();
		}else {
			result = bookDao.search(keyword);
		}
		request.setAttribute("result", result);
		request.setAttribute("keyword", keyword);
		String resultPage = "/frontend/search_result.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(resultPage);
		dispatcher.forward(request, response);
	}
}
