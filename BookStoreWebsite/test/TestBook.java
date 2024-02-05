import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.bookstore.entity.entity3.Book;
import com.bookstore.entity.entity3.Category;

public class TestBook {
	public static void main(String[] args) {
		Book book = new Book();
		book.setTitle("Demo");
		book.setAuthor("Nguyen Binh");
		book.setDescription("Tac gia cua nhung");
		book.setIsbn("ISBn");
		book.setImage(new byte[] {2,1,3,4,5});
		book.setPrice(40.4);
		book.setPublish_date(new Date());
		book.setLast_update_time(new Timestamp(2));
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("BookStoreWebsite");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		Category cate = entityManager.find(Category.class, 1);
		book.setCategory(cate);
		
		
		
		entityManager.persist(book);
		entityManager.getTransaction().commit();
		entityManager.close();
//		entityManager.close();
		System.out.println("A users object was persisted!!");
	}
}
