package com.bookstore.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.bookstore.entity.entity3.Book;
import com.bookstore.entity.entity3.Review;

class BookRatingTest extends BaseDAOTest{

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@org.junit.Test
	void test() {
		Book book = new Book();
		List<Review>reviews = new ArrayList<Review>();
		Review r1 = new Review();
		r1.setFating(5);
		reviews.add(r1);
		
		book.setReviews(reviews);
		float averRating =  book.getAverageRating();
	
		assertEquals(5.0, averRating);
	}
	@org.junit.Test
	public void testRatingString1() {
		float averageRating = 0.0f;
		Book book = new Book();
		String ratingString = book.getRatingString(averageRating);
		String expect = "off,off,off,off,off";
		assertEquals(expect, ratingString);
	}

}
