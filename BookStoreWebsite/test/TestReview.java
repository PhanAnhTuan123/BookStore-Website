import java.sql.Timestamp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.bookstore.entity.entity3.Address;
import com.bookstore.entity.entity3.Book;
import com.bookstore.entity.entity3.Customer;
import com.bookstore.entity.entity3.Review;

public class TestReview {
	public static void main(String[] args) {
		Review rv = new Review();
		rv.setComment("Tuyet voi");
		rv.setFating(3);
		rv.setHeadline("Ting Ting");
		rv.setReview_time(new Timestamp(System.currentTimeMillis()));
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("BookStoreWebsite");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
//		entityManager.persist(cus);		
		Book book = entityManager.find(Book.class, 1);
		Customer cus = entityManager.find(Customer.class, 1);
		rv.setBook(book);
		rv.setCustomer(cus);
		entityManager.persist(rv);
		System.out.println(book.toString());
		
		entityManager.getTransaction().commit();
		entityManager.close();

		System.out.println("A users object was persisted!!");
	}
}
