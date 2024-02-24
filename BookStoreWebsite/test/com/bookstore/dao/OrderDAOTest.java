package com.bookstore.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.bookstore.entity.entity3.Book;
import com.bookstore.entity.entity3.BookOrder;
import com.bookstore.entity.entity3.Customer;
import com.bookstore.entity.entity3.OrderDetail;
import com.bookstore.entity.entity3.OrderdetailID;
import com.bookstore.enumeration.Payment_method;
import com.bookstore.enumeration.StatusBookOrder;

class OrderDAOTest extends BaseDAOTest {
	private static OrderDAO orderDao;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		orderDao = new OrderDAO(entityManager);
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		orderDao.close();
	}

	@Test
	void testCreateBookOrder() {
		BookOrder order = new BookOrder();
		Customer customer = new Customer();
		customer.setCustomerId(3);
		order.setCustomer_id(customer);
		order.setPayment_method(Payment_method.cash);
		order.setRecipient_phone("12345667");
		order.setRecipient_name("Phan anh tuan");
		order.setStatus(StatusBookOrder.Processing);
		order.setShipping_address("69 Chua Lang");
		List<OrderDetail> list = (List<OrderDetail>) new HashSet<OrderDetail>();
		List<OrderDetail> orderDetails = list;
		OrderDetail orderDetail = new OrderDetail();
		orderDetails.add(orderDetail);
		order.setDetail(orderDetails);
		Book book = new Book();
		book.setBookID(1);
		orderDetail.setBook(book);
		OrderdetailID id = new OrderdetailID();
		id.setBookId(book.getBookID());
		id.setOrderId(order.getOrderId());
		order.setCustomer_id(customer);

		BookOrder bookOrder = orderDao.create(order);
		assertNotNull(bookOrder);

	}

	@Test
	void testGet() {
		Integer orderId = 9;
		BookOrder order = orderDao.get(orderId);
		assertNotNull(order);
	}

	@Test
	void testDeleteObject() {
		int id = 9;
		orderDao.delete(id);
		BookOrder order = orderDao.get(id);
		assertNull(order);
	}

	@org.junit.Test
	public void testUpdateBookOrderShippingAddress() {
		Integer orderId = 9;
		BookOrder order = orderDao.get(orderId);
		order.setShipping_address("New Shipping Address");
		orderDao.update(order);
		BookOrder updatedOrder = orderDao.get(orderId);
		assertEquals(order.getShipping_address(), updatedOrder.getShipping_address());
	}

	@org.junit.Test
	public void testUpdateBookOrderDetail() {
		Integer id = 10;
		BookOrder order = orderDao.get(id);
		Iterator<OrderDetail>iterator = order.getDetail().iterator();
		while(iterator.hasNext()){
			OrderDetail orderDetail = iterator.next();
			if(orderDetail.getBook().getBookID() ==5) {
				orderDetail.setQuantity(3);
				orderDetail.setSubtotal(120);
			}
		}
		orderDao.update(order);
		BookOrder updatedOrder = orderDao.get(id);
		assertEquals(order.getShipping_address(), updatedOrder.getShipping_address());
		
	}

	void testListAll() {
		List<BookOrder> listOrder = orderDao.listAll();
		listOrder.forEach(c -> System.out.println(c.toString()));
		assertTrue(listOrder.size() > 0);
	}

	@Test
	void testCount() {
		long total  = orderDao.count();
		assertTrue(total > 0);
	}
	

}
