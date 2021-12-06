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
		session = factory.openSession();
	}
	
	@Override
	public void close() {
		if(session != null)
			session.close();
	}
	
	public Book findById(int id) {
		return session.get(Book.class, id);
	}
	
	public List<Book> findAll() {
		String hql = "SELECT b FROM Book b";
		Query<Book> q = session.createQuery(hql);
		return q.getResultList();
	}
	
	public void save(Book b) {
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.persist(b);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
	}
	
	public void update(Book b) {
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.update(b);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
	}

	public void deleteById(int id) {
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Book b = session.get(Book.class, id);
			if(b != null)
				session.delete(b);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
	}
}













