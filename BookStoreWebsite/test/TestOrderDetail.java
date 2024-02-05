import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.bookstore.entity.entity3.Book;
import com.bookstore.entity.entity3.BookOrder;
import com.bookstore.entity.entity3.Category;
import com.bookstore.entity.entity3.OrderDetail;
import com.bookstore.entity.entity3.OrderdetailID;

public class TestOrderDetail {
	public static void main(String[] args) {
		OrderdetailID id = new OrderdetailID();
		id.setBookId(1);
		id.setOrderId(2);
		OrderDetail detail = new OrderDetail();
		detail.setId(id);
		detail.setQuantity(20);
		detail.setSubtotal(0);
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("BookStoreWebsite");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		BookOrder order = entityManager.find(BookOrder.class, 1);
		Book book =  entityManager.find(Book.class, 1);
		detail.setBook(book);
		detail.setBookOrder(order);
		entityManager.persist(detail);
		
		
		entityManager.getTransaction().commit();
		entityManager.close();
//		entityManager.close();
		System.out.println("A users object was persisted!!");
	}
}
