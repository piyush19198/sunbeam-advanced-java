package com.sunbeam;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class BookDaoImpl implements AutoCloseable {
	private Session session;
	
	public BookDaoImpl() {
		SessionFactory factory = HbUtil.getSessionFactory();
		session = factory.getCurrentSession();
	}
	
	public void close() {
	}
	
	public Book getById(int id) {
		return session.get(Book.class, id);	// SQL
	}
	
	public Book findById(int id) {
		return session.find(Book.class, id); // SQL
	}

	public Book loadById(int id) {
		return session.load(Book.class, id); // Return Proxy
	}

	public List<Book> findAll() {
		String hql = "SELECT b FROM Book b";
		Query<Book> q = session.createQuery(hql);
		return q.getResultList();
	}
	
	public void save(Book b) {
		session.persist(b);
		System.out.println("Saving: " + b);
	}
	
	public void update(Book b) {
		session.update(b);
	}

	public void deleteById(int id) {
		Book b = session.get(Book.class, id);	// b --> Persistent 
		if(b != null)
			session.delete(b);	// b --> Removed
			// session.remove(b);	// b --> Removed
	}
	
	public void merge(Book b) {
		session.merge(b);
		// session.saveOrUpdate(b);
	}
}













