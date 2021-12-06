package com.sunbeam.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sunbeam.entities.Book;

public interface BookDao extends JpaRepository<Book, Integer> {
	List<Book> findBySubject(String subject); // findBy Subject --> WHERE subject = ?
	List<Book> findBySubjectAndAuthor(String subject, String author);
	List<Book> findByPriceGreaterThanOrderByPriceDesc(double price);
	List<Book> findByTitleContaining(String title);
	@Query("SELECT b.bookId, b.title, b.price FROM Book b")
	List<Object[]> findAllIdNamePrice();
	@Query("SELECT new Book(b.bookId, b.title, b.author) FROM Book b")
	List<Book> findAllIdNameAuthor();
}
