package com.bookstore.entity.entity3;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class OrderdetailID implements Serializable{
	@Column(name = "order_id")
	private Integer orderId;
	@Column(name = "book_id")
	private Integer bookId;
	public OrderdetailID(Integer orderId, Integer bookId) {
		super();
		this.orderId = orderId;
		this.bookId = bookId;
	}
	public OrderdetailID() {
		super();
	}
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public Integer getBookId() {
		return bookId;
	}
	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}
	@Override
	public int hashCode() {
		return Objects.hash(bookId, orderId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderdetailID other = (OrderdetailID) obj;
		return Objects.equals(bookId, other.bookId) && Objects.equals(orderId, other.orderId);
	}
	@Override
	public String toString() {
		return "OrderdetailID [orderId=" + orderId + ", bookId=" + bookId + "]";
	}
	
	
	
}
