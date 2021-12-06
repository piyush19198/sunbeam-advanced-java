package com.sunbeam;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class BookDaoImpl implements BookDao {
	@PersistenceContext // or @Autowired
	private EntityManager em;

	public Book findById(int id) {
		Book b = em.find(Book.class, id);
		return b;
	}

	public void save(Book b) {		
		em.persist(b);
	}

	public void update(Book b) {
		em.merge(b);
	}

	public void deleteById(int id) {
		Book b = em.find(Book.class, id);
		if(b != null)
			em.remove(b);
	}
	
	public List<Book> findAll() {
		String hql = "from Book b";
		Query q = em.createQuery(hql);
		return q.getResultList();
	}
}
