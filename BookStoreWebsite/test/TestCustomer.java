import java.sql.Timestamp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.bookstore.entity.entity3.Address;
import com.bookstore.entity.entity3.Book;
import com.bookstore.entity.entity3.Category;
import com.bookstore.entity.entity3.Customer;

public class TestCustomer {
	public static void main(String[] args) {
		Address add = new Address();
		add.setAddress("Quan 3");
		add.setCity("Ho Chi Minh");
		add.setCountry("Viet Nam");
		add.setZipcode("1103");
		Customer cus = new Customer();
		cus.setAddress(add);
		cus.setEmail("nguyenVan@gmail.com");
		cus.setFullname("Nguyen Van A");
		cus.setPassword("03358692");
		cus.setPhone("013519666");
		cus.setRegister_date(new Timestamp(System.currentTimeMillis()));
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("BookStoreWebsite");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
//		entityManager.persist(cus);		
		if(!entityManager.contains(cus)) {
			entityManager.persist(cus);
		}else {
			System.out.println("Trung lap khong mong muon");
		}
		
		entityManager.getTransaction().commit();
		entityManager.close();
//		entityManager.close();
		System.out.println("A users object was persisted!!");
	}
}
