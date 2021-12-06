package com.sunbeam.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sunbeam.daos.BookDaoImpl;
import com.sunbeam.entities.Book;

@Transactional
@Service
public class BookServiceImpl {
	@Autowired
	private BookDaoImpl bookDao;
	
	public Book findById(int id) {
		return bookDao.findById(id);
	}
	
	public void save(Book b) {
		bookDao.save(b);
	}
}
