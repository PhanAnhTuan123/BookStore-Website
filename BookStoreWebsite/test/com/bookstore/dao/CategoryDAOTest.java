package com.bookstore.dao;

import static org.junit.Assert.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.bookstore.entity.entity3.Category;

public class CategoryDAOTest extends BaseDAOTest{

	private static CategoryDAO categoryDAO;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		entityManagerFactory = Persistence.createEntityManagerFactory("BookStoreWebsite");
		entityManager = entityManagerFactory.createEntityManager();
		categoryDAO = new CategoryDAO(entityManager);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		entityManager.close();
		entityManagerFactory.close();
	}

	@Test
	public void testUpdateCategory() {
		Category cat = new Category();
		cat.setName("Java Core");
		cat.setCategoryId(1);
		Category cate = categoryDAO.update(cat);
		assertEquals(cat.getName(), cate.getName());
		
	}

	@Test
	public void testCreateCategory() {
		Category newCat = new Category("Java");
		categoryDAO = new CategoryDAO(entityManager);
		Category category = categoryDAO.create(newCat);
		
		
		assertTrue(category !=null && category.getCategoryId() > 0);

	}

	@Test
	public void testGet() {
		Integer catId = 2;
		Category cat = categoryDAO.get(catId);
		assertNotNull(cat);
		
	}

	@Test
	public void testDeleteObject() {
		Integer catId = 3;
		categoryDAO.delete(catId);
		Category cat = categoryDAO.get(catId);
		assertNull(cat);
	}

	@Test
	public void testListAll() {
		List<Category>listCategory = categoryDAO.listAll();
		listCategory.forEach(c-> System.out.println(c.getName()));
		assertTrue(listCategory.size() > 0);
		
	}

	@Test
	public void testCount() {
		long totalCat = categoryDAO.count();
		assertTrue(totalCat > 0);
	}

}
