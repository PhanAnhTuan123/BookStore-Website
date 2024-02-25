package com.bookstore.dao;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;

import com.bookstore.entity.entity3.Book;
import com.bookstore.entity.entity3.BookOrder;
import com.bookstore.entity.entity3.Customer;

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
	public BookOrder get(Object id,Integer customerId) {
		Map<String, Object>parameters = new HashMap<String, Object>();
		parameters.put("orderId", id);
		parameters.put("customerId", customerId);
		List<BookOrder>result = super.findWithNamedQuery("BookOrder.findByIdAndCustomer", parameters);
		if(!result.isEmpty()) {
			return result.get(0);
		}
		return null;
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
	public List<BookOrder>listByCustomer(Integer id){
		
		return super.findWithNamedQuery("BookOrder.findByCustomer","customerId",id);
	}
	public List<BookOrder>listMostRecentSales(){
		return super.findWithNamedQuery("BookOrder.findAll",0,3);
		
	}
}
