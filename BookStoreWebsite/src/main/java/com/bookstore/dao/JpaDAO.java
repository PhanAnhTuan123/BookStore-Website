package com.bookstore.dao;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class JpaDAO<E> {
	protected EntityManager entityManager;
	private static EntityManagerFactory entityManagerFactory;
	
	static {
		entityManagerFactory = Persistence.createEntityManagerFactory("BookStoreWebsite");
	}
	
	public JpaDAO() {
		super();
		entityManagerFactory = Persistence.createEntityManagerFactory("BookStoreWebsite");

	}

	public JpaDAO(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}
	
	public E create(E t) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(t);
		entityManager.refresh(t);
		
		entityManager.getTransaction().commit();
		entityManager.close();
		return t;
	}
	public E update(E entity) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		entity =  entityManager.merge(entity);
		entityManager.getTransaction().commit();
		entityManager.close();
		return entity;
	}
	public E find(Class<E> type,Object id) {
		E entity =  entityManager.find(type, id);
		if(entity !=null) {
			entityManager.refresh(entity);
		}
		entityManager.close();
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
		entityManager.close();
	}
	public List<E>findWithNamedQuery(String queryName){
		Query query = entityManager.createNamedQuery(queryName);
		
		return query.getResultList();
	}
	public List<E>findWithNamedQuery(String queryName,String paraName,Object paraValue){
		Query query = entityManager.createNamedQuery(queryName);
		query.setParameter( paraName, paraValue);
		return query.getResultList();
	}
	public List<E>findWithNamedQuery(String queryName,Map<String, Object>parameters){
		Query query = entityManager.createNamedQuery(queryName);
		Set<Entry<String,Object>>rawParameters =  parameters.entrySet();
		for(Entry<String,Object>entry: rawParameters) {
			query.setParameter(entry.getKey(), entry.getValue());
		}
//		query.setParameter( paraName, paraValue);
		return query.getResultList();
	}
	public List<E>findWithNamedQuery(String queryName,Object paraValue){
		Query query = entityManager.createNamedQuery(queryName);
		query.setParameter("name", paraValue);
		return query.getResultList();
	}
	
	public long countWithNamedQuery(String queryName) {
		Query query = entityManager.createNamedQuery(queryName);
		return (long) query.getSingleResult();
	}
	public long countWithNamedQuery(String queryName,String paramName,Object paramValue) {
		Query query = entityManager.createNamedQuery(queryName);
		query.setParameter(paramName, paramValue);
		return (long) query.getSingleResult();
	}
	public void close() {
		if (entityManagerFactory !=null) {
			entityManagerFactory.close();
		}
	}
}
