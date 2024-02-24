package com.bookstore.dao;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import com.bookstore.entity.entity3.BookOrder;

public class OrderDAO extends JpaDAO<BookOrder> implements GenericDAO<BookOrder> {

	public OrderDAO(EntityManager entityManager) {
		super(entityManager);
	}
	@Override
	public BookOrder update(BookOrder entity) {
		return super.update(entity);
	}
	@Override
	public BookOrder create(BookOrder t) {
		t.setOrder_date(new Timestamp(System.currentTimeMillis()));
		return super.create(t);
	}
	@Override
	public BookOrder get(Object id) {
		
		return super.find(BookOrder.class, id);
	}

	@Override
	public void delete(Object id) {
		super.delete(BookOrder.class, id);
	}

	@Override
	public List<BookOrder> listAll() {
		// TODO Auto-generated method stub
		return super.findWithNamedQuery("BookOrder.listAll");
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return super.countWithNamedQuery("BookOrder.countAll");
	}

}
