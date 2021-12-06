package com.sunbeam.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sunbeam.daos.BookDao;
import com.sunbeam.entities.Book;

@Transactional
@Service
public class BookServiceImpl {
	@Autowired
	private BookDao bookDao;
	
	public Book findBookById(int id) {
		Optional<Book> b = bookDao.findById(id);
		return b.orElse(null);
	}
	
	public List<Book> findBookBySubject(String subject) {
		return bookDao.findBySubject(subject);
	}
	
	public List<Book> findBookBySubjectAndAuthor(String subject, String author) {
		return bookDao.findBySubjectAndAuthor(subject, author);
	}
	
	public List<Book> findBookByPriceGreaterThanOrderByPriceDesc(double price) {
		return bookDao.findByPriceGreaterThanOrderByPriceDesc(price);
	}
	
	public List<Book> findBookByTitleContaining(String title) {
		return bookDao.findByTitleContaining(title);
	}
	
	public List<Book> findAllBooks() {
		return bookDao.findAll();
	}
	
	public Book saveBook(Book b) {
		return bookDao.save(b);
	}
	
	public void deleteBookById(int id) {
		bookDao.deleteById(id);
	}
}





