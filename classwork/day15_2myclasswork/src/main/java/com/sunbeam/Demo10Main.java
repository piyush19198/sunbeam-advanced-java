package com.sunbeam;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class Demo10Main {
	public static void main(String[] args) {
		// hibernateSimplified();		
		try (BookDaoImpl dao = new BookDaoImpl()) {
			Book b = dao.findById(11);
			System.out.println("Found: " + b);
			System.out.println("Final Cost : " + b.getFinalCost());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void hibernateSimplified() {
		System.out.println("Hello, Hibernate!");
		SessionFactory factory = HbUtil.getSessionFactory();
		
		Session session = null;
		Transaction tx = null;
		
		session = factory.openSession();
		Book b1 = session.get(Book.class, 11);
			// 1. It reads annotations on Book.class (using reflection) -- Table name & Column names.
			// 2. Create SQL query -- SELECT on the Table for all the columns mapped in Book POJO.
			// 3. Use JDBC connection to create Statement and execute it -- Give ResultSet.
			// 4. If resultSet has row, create object of the Book POJO (using reflection).
			// 5. Get values from resultSet and call setters on POJO object (using reflection).
			// 6. Close all -- resultSet, Statement.
		
			// step 5 -- Setters are invoked if ORM annotations are written on getter methods.
			// If ORM annotations are written on field level, setters are not called. Directly fields are assigned (using reflection).
		System.out.println("Found: " + b1);
		session.close();
		
		session = factory.openSession();
		try {
			tx = session.beginTransaction();
			Book b2 = new Book(51, "Atlas Shrugged", "Ayn", "Novell", 623.00);
			session.persist(b2);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
		session.close();

		session = factory.openSession();
		try {
			tx = session.beginTransaction();
			Book b3 = session.get(Book.class, 51);
			if(b3 != null) {
				b3.setPrice(540.0);
				b3.setAuthor("Ayn Rand");
				session.update(b3);
			}
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
		session.close();		
		
		session = factory.openSession();
		//String sql = "SELECT * FROM books b";	// SQL --> RDBMS Table & Columns
		String hql = "SELECT b FROM Book b"; // HQL --> Hibernate Entity & Fields
		Query<Book> q = session.createQuery(hql);
		List<Book> list = q.getResultList();
		list.forEach(System.out::println);
		session.close();		
		
		session = factory.openSession();
		try {
			tx = session.beginTransaction();
			Book b4 = session.get(Book.class, 51);
			if(b4 != null)
				session.delete(b4);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
		session.close();		
		
		HbUtil.shutdown();
	}
}




