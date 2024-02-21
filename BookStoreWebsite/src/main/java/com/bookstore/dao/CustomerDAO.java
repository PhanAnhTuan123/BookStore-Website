package com.bookstore.dao;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import com.bookstore.entity.entity3.Customer;

public class CustomerDAO extends JpaDAO<Customer> implements GenericDAO<Customer> {
	public CustomerDAO(EntityManager entityManager) {
		super(entityManager);
	}
	@Override
	public Customer create(Customer t) {
		t.setRegister_date(new Timestamp(System.currentTimeMillis()));
		return super.create(t);
	}

	@Override
	public Customer update(Customer entity) {
		// TODO Auto-generated method stub 
		return super.update(entity);
	}

	@Override
	public void delete(Class<Customer> type, Object id) {
		// TODO Auto-generated method stub
		super.delete(type, id);
	}

	@Override
	public Customer get(Object id) {
		// TODO Auto-generated method stub
		return super.find(Customer.class, id);
	}

	@Override
	public void delete(Object id) {
		 super.delete(Customer.class, id);
	}

	@Override
	public List<Customer> listAll() {
		// TODO Auto-generated method stub
		return super.findWithNamedQuery("Customer.findAll");
	}

	@Override
	public long count() {
		return super.countWithNamedQuery("Customer.countAll");
	}
	public Customer findByEmail(String email) {
		List<Customer>result =  super.findWithNamedQuery("Customer.findByEmail","email",email);
		if(!result.isEmpty()) {
			return result.get(0);
		}
		return null;
	}
}
