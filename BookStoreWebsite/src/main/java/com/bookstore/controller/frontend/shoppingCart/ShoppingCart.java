package com.bookstore.controller.frontend.shoppingCart;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.hibernate.mapping.Subclass;

import com.bookstore.entity.entity3.Book;

public class ShoppingCart {
	private Map<Book, Integer>cart = new HashMap<Book, Integer>();
	public void addItem(Book book) {
		if(cart.containsKey(book)) {
			Integer quantity = cart.get(book) + 1;
			cart.put(book, quantity);
			
		}else {
			cart.put(book, 1);
		}
	}
	public void removeItem(Book book) {
		cart.remove(book);
	}
	public int getTotalQuantity() {
		int total = 0;
		Iterator<Book>iterator = cart.keySet().iterator();
		while(iterator.hasNext()) {
			Book next = iterator.next();
			Integer quantity = cart.get(next);
			total+=quantity;
		}
		return total;
	}
	public double getTotalAmount() {
		double total = 0.0f;
		Iterator<Book>iterator = cart.keySet().iterator();
		while(iterator.hasNext()) {
			Book book = iterator.next();
			Integer quantity = cart.get(book);
			double subTotal= quantity*book.getPrice();
			total +=subTotal;
		}
		return total;
	}
	public Map<Book, Integer>getItems(){
		return this.cart;
	}
	public void clear() {
		cart.clear();
	}
}
