import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.bookstore.entity.entity3.Book;
import com.bookstore.entity.entity3.BookOrder;
import com.bookstore.entity.entity3.Category;
import com.bookstore.entity.entity3.Customer;
import com.bookstore.enumeration.Payment_method;
import com.bookstore.enumeration.StatusBookOrder;

public class TestBookOrder {
	public static void main(String[] args) {
		BookOrder or = new BookOrder();
		or.setOrder_date(new Timestamp(System.currentTimeMillis()));
		or.setPayment_method(Payment_method.banking);
		or.setShipping_address("Landmark 81");
		or.setRecipient_name("Cty tu nhan");
		or.setRecipient_phone("01235996");
		or.setTotal(123.54);
		or.setStatus(StatusBookOrder.Processing);
		
		
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("BookStoreWebsite");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		Customer cus = entityManager.find(Customer.class, 1);
		or.setCustomer_id(cus);
		entityManager.persist(or);
		
		entityManager.getTransaction().commit();
		entityManager.close();
//		entityManager.close();
		System.out.println("A users object was persisted!!");
	}
}
