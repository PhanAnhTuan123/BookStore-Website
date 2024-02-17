import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.bookstore.entity.entity3.Book;
import com.bookstore.entity.entity3.Category;

import antlr.collections.List;

public class TestCategory {
	public static void main(String[] args) {
		Category cate = new Category("Truyen thuyet");
//		cate.setName("Than thoai");
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("BookStoreWebsite");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		entityManager.persist(cate);
		
//		Category catego = entityManager.find(Category.class,1);
//		java.util.List<Book>book = catego.getBooks();
//		for (Book book2 : book) {
//			System.out.println(book2.toString());
//		}
		
		
		entityManager.getTransaction().commit();
		entityManager.close();
//		entityManager.close();
		System.out.println("A users object was persisted!!");
	}
}
