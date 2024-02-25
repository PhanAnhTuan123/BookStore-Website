package com.bookstore.dao;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;

import com.bookstore.entity.entity3.Review;

public class ReviewDAO extends JpaDAO<Review> implements GenericDAO<Review>{
	
	
	public ReviewDAO(EntityManager entityManager) {
		super(entityManager);
		// TODO Auto-generated constructor stub
	}
	
	
	
	@Override
	public Review create(Review t) {
		t.setReview_time(new Timestamp(System.currentTimeMillis()));
		return super.create(t);
	}



	@Override
	public Review update(Review entity) {
		// TODO Auto-generated method stub
		return super.update(entity);
	}



	@Override
	public void delete(Class<Review> type, Object id) {
		// TODO Auto-generated method stub
		super.delete(type, id);
	}



	@Override
	public Review get(Object id) {
		return super.find(Review.class, id);
	}

	@Override
	public void delete(Object id) {
		super.delete(Review.class, id);
	}

	@Override
	public List<Review> listAll() {
		return super.findWithNamedQuery("Review.listAll");
	}

	@Override
	public long count() {
		return super.countWithNamedQuery("Review.countAll");
	}
	public Review findByCustomerAndBook(int customerId,int bookId) {
		Map<String , Object>parameters= new HashMap<String, Object>();
		parameters.put("customerId", customerId);
		parameters.put("bookId", bookId);
		List<Review>result =  super.findWithNamedQuery("Review.findByCustomerAndBook",parameters);
		if(!result.isEmpty()) {
			return result.get(0);
		}
		return null;
	}
	public List<Review>listMostRecent(){
		return super.findWithNamedQuery("Review.listAll",0,3);
	}
}
