package com.bookstore.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.bookstore.entity.entity3.Address;
import com.bookstore.entity.entity3.Customer;

class CustomerDAOTest {
	private static CustomerDAO customerDAO;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		customerDAO = new CustomerDAO();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		customerDAO.close();
	}

	@Test
	void testCreateCustomer() {
		Customer cus = new Customer();
		cus.setEmail("tomholand@gmail.com");
		cus.setFullname("Harry ");
		Address add = new Address("69 Chua Lang","Thanh Xuan","Dong Da","1010");
		cus.setAddress(add);
		cus.setPassword("tom123");
		cus.setPhone("0145979596");
		Customer savedCus = customerDAO.create(cus);
		assertTrue(savedCus.getCustomerId() > 0);
	}

	@Test
	void testUpdateCustomer() {
		Customer cus = customerDAO.get(1);
		cus.setFullname("Tom");
		Customer cusUpdate =  customerDAO.update(cus);
		assertTrue(cusUpdate.getFullname().equals(cus.getFullname()));
	}

	@Test
	void testDeleteClassOfCustomerObject() {
		Integer cusId = 1;
		customerDAO.delete(cusId);
		Customer cust = customerDAO.get(1);
		assertNull(cust);
	}

	@Test
	void testGet() {
		Integer id =1;
		Customer cus = customerDAO.get(id);
		assertNotNull(cus);
	}

	@Test
	void testListAll() {
		List<Customer>listCustomers = customerDAO.listAll();
		assertTrue(!listCustomers.isEmpty());
	}

	@Test
	void testCount() {
		int totalCountCus = (int) customerDAO.count();
		assertTrue(totalCountCus > 0);
	}
	
	@org.junit.Test
	public void testFindByEmail() {
		String email = "tom@gmail.com";
		Customer customer = customerDAO.findByEmail(email);
		assertNotNull(customer);
	}
}
