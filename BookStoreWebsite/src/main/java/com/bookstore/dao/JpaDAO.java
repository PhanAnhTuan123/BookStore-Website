package com.bookstore.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class JpaDAO<E> {
	protected EntityManager entityManager;

	public JpaDAO(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}
	
	public E create(E t) {
		entityManager.getTransaction().begin();
		entityManager.persist(t);
		entityManager.refresh(t);
		
		entityManager.getTransaction().commit();
		
		return t;
	}
	public E update(E entity) {
		entityManager.getTransaction().begin();
		entity =  entityManager.merge(entity);
		entityManager.getTransaction().commit();
		return entity;
	}
	public E find(Class<E> type,Object id) {
		E entity =  entityManager.find(type, id);
		if(entity !=null) {
			entityManager.refresh(entity);
		}
		return entity;
	}
	public void delete(Class<E>type,Object id) {
		entityManager.getTransaction().begin();
		
//		Object reference = entityManager.getReference(type, id);
		
//		entityManager.remove(reference);
		Object entity = entityManager.find(type, id);
		System.out.println(entity.toString());
		if(entity!=null) {
			entityManager.remove(entity);
		}
		entityManager.getTransaction().commit();
	}
	public List<E>findWithNamedQuery(String queryName){
		Query query = entityManager.createNamedQuery(queryName);
		return query.getResultList();
	}
	public long countWithNamedQuery(String queryName) {
		Query query = entityManager.createNamedQuery(queryName);
		return (long) query.getSingleResult();
	}
}
