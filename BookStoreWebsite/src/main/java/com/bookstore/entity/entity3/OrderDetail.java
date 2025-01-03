package com.bookstore.entity.entity3;
// Generated Feb 4, 2024, 9:52:51 AM by Hibernate Tools 5.6.15.Final

import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * OrderDetail generated by hbm2java
 */
@Entity
@Table(name = "order_detail")
@NamedQueries({
	@NamedQuery(name = "OrderDetail.bestSelling",query = "Select od.book from OrderDetail od "
			+ "group by od.bookId order by sum(od.quantity) desc")
})
public class OrderDetail implements java.io.Serializable {
	@EmbeddedId
	private OrderdetailID id;

	@Column(name = "quantity",nullable = false)
	private Integer quantity;
	@Column(name = "subtotal",nullable = false)
	private double subtotal;
	

	@ManyToOne(cascade = { CascadeType.PERSIST})
	@JoinColumn(name = "book_id")
	@MapsId("bookId")
	private Book book;

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.REMOVE })
	@JoinColumn(name = "order_id")
	@MapsId("orderId")
	private BookOrder bookOrder;

	public OrderDetail() {
		super();
	}

	public OrderDetail(OrderdetailID id, Integer quantity, Book book, BookOrder bookOrder) {
		super();
		this.id = id;
		this.quantity = quantity;
		this.book = book;
		this.bookOrder = bookOrder;
	}

	public OrderdetailID getId() {
		return id;
	}

	public void setId(OrderdetailID id) {
		this.id = id;
	}

	public double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Book getBook() {
		return book;
	}

	@Override
	public String toString() {
		return "OrderDetail [id=" + id + ", quantity=" + quantity + ", book=" + book + ", bookOrder=" + bookOrder + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(bookOrder, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderDetail other = (OrderDetail) obj;
		return Objects.equals(bookOrder, other.bookOrder) && Objects.equals(id, other.id);
	}

	public void setBook(Book book) {
		this.book = book;
		book.addOrder(this);
	}

	public BookOrder getBookOrder() {
		return bookOrder;
		
	}

	public void setBookOrder(BookOrder bookOrder) {
		this.bookOrder = bookOrder;
		bookOrder.addDetail(this);
	}

}
