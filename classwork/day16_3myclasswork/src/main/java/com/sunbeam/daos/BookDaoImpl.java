package com.sunbeam.daos;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.sunbeam.entities.Book;

@Repository
public class BookDaoImpl {
	@Autowired
	private SessionFactory sessionFactory;

	public Book findById(int id) {
		Session session = sessionFactory.getCurrentSession();
		return session.find(Book.class, id);
	}
	
	public void save(Book b) {
		Session session = sessionFactory.getCurrentSession();
		session.save(b);
	}

	// ...
}
