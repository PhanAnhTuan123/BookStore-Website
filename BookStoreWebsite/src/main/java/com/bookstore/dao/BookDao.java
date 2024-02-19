package com.bookstore.dao;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import com.bookstore.entity.entity3.Book;

public class BookDao extends JpaDAO<Book> implements GenericDAO<Book> {

	public BookDao(EntityManager entityManager) {
		super(entityManager);
		// TODO Auto-generated constructor stub
	}
	@Override
	public Book create(Book t) {
		t.setLast_update_time(new Timestamp(System.currentTimeMillis()));
		return super.create(t);
	}
	@Override
	public Book update(Book entity) {
		entity.setLast_update_time(new Timestamp(System.currentTimeMillis()));
		return super.update(entity);
	}

	@Override
	public Book get(Object id) {
		return super.find(Book.class, id);
	}

	@Override
	public void delete(Object id) {
		super.delete(Book.class, id);
		
	}

	@Override
	public List<Book> listAll() {
		return super.findWithNamedQuery("Book.findAll");
	}
	public Book findByTitle(String title) {
		List<Book>result =  super.findWithNamedQuery("Book.findByTittle","title",title);
		if(!result.isEmpty()) {
			return result.get(0);
		}
		return null;
	}
	@Override
	public long count() {
		// TODO Auto-generated method stub
		return super.countWithNamedQuery("Book.countAll");
	}

}
