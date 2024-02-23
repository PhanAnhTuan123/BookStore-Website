package com.bookstore.controller.frontend.shoppingCart;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.bookstore.entity.entity3.Book;

public class ShoppingCartTest {
	private static ShoppingCart cart;

	@BeforeClass
	public static void setUpBefore() throws Exception{
		cart = new ShoppingCart();
		Book book = new Book(1);
		book.setBookID(1);
		cart.addItem(book);
		cart.addItem(book);
		
	}

	@Test
	public void testAddItem() {
		ShoppingCart cart = new ShoppingCart();
		Book book = new Book();
		book.setBookID(1);
		
		cart.addItem(book);
		Map<Book, Integer>items =  cart.getItems();
		int quantity = items.get(book);	
		
		assertEquals(1, quantity);
	}
	@Test
	public void testRemoveItem() {
		Book book2 = new Book(2);
		cart.addItem(book2);
		
		cart.removeItem(new Book(1));
		assertTrue(cart.getItems().isEmpty());
	}
	@Test
	public void testGetTotalQuantity() {
		Book book3 = new Book(3);
		cart.addItem(book3);
		cart.addItem(book3);
		cart.addItem(book3);
		assertEquals(5, cart.getTotalQuantity());
	}
	@Test
	public void testGetTotalAmount() {
		ShoppingCart cart = new ShoppingCart();
		assertTrue(cart.getTotalAmount() == 0);
	}
	@Test
	public void testClear() {
		cart.clear();
		assertEquals(0, cart.getTotalQuantity());
	}

}
