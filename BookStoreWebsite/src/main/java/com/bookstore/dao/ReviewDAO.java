package com.bookstore.dao;

import java.sql.Timestamp;
import java.util.List;

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
	
}
