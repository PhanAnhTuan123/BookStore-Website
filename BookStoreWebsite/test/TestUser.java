import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.bookstore.entity.Users;

public class TestUser {
	public static void main(String[] args) {
		com.bookstore.entity.entity3.Users user1 = new com.bookstore.entity.entity3.Users();
		user1.setEmail("kiet@gmail.com");
		user1.setFullName("phanAnhKiet");
		user1.setPassword("power");
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("BookStoreWebsite");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		entityManager.persist(user1);
		entityManager.getTransaction().commit();
		entityManager.close();
		entityManager.close();
		System.out.println("A users object was persisted!!");
	}
}
