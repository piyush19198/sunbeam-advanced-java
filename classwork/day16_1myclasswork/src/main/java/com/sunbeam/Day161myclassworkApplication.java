package com.sunbeam;

import org.hibernate.Session;

public class Day161myclassworkApplication {
	public static void main(String[] args) {
		/*
		// hibernate.current_session_context_class = thread
		Session session1 = HbUtil.getSession();
		Session session2 = HbUtil.getSession();
		System.out.println("Same Session in same thread: " + (session1 == session2));
		
		// if in new thread, will return new session
		new Thread(() -> {
			Session session3 = HbUtil.getSession();
			System.out.println("Same Session in different thread: " + (session1 == session3));
		}).start();
		*/
		
		/*
		try (BookDaoImpl dao = new BookDaoImpl()) {
			HbUtil.beginTransaction();
			Book b = dao.findById(11);
			System.out.println("Found: " + b);
			HbUtil.commitTransaction();
		} catch (Exception e) {
			e.printStackTrace();
			HbUtil.rollbackTransaction();
		}
		*/
		
		/*
		try (BookDaoImpl dao = new BookDaoImpl()) {
			HbUtil.beginTransaction();
			Book b = new Book(51, "Atlas Shrugged", "Ayn", "Novell", 762.32);
			dao.save(b);
			HbUtil.commitTransaction();
		} catch (Exception e) {
			e.printStackTrace();
			HbUtil.rollbackTransaction();
		}
		*/
		
		/*
		try (BookDaoImpl dao = new BookDaoImpl()) {
			HbUtil.beginTransaction();
			Book b1 = dao.findById(11);
			System.out.println("Found: " + b1);
			Book b2 = dao.findById(11);
			System.out.println("Found: " + b2);
			System.out.println("Same Object: " + (b1 == b2));
			
			HbUtil.getSession().refresh(b2);
			
			HbUtil.commitTransaction();
		} catch (Exception e) {
			e.printStackTrace();
			HbUtil.rollbackTransaction();
		}
		*/

		/*
		try (BookDaoImpl dao = new BookDaoImpl()) {
			HbUtil.beginTransaction();
			Book b = dao.findById(51);
			System.out.println("Found: " + b);
			
			b.setAuthor("Ayn Rand");
			b.setPrice(692.00);
			
			HbUtil.commitTransaction();
		} catch (Exception e) {
			e.printStackTrace();
			HbUtil.rollbackTransaction();
		}
		*/
		
		/*
		Book x = new Book(53, "The Alchemist", "Cohelo", "Novell", 500.00); // Transient (Not yet added into session)
		try (BookDaoImpl dao = new BookDaoImpl()) {
			HbUtil.beginTransaction();
			dao.save(x);			// Persistent (Added into session i.e. part of session cache)
			HbUtil.commitTransaction();	// persist() --> INSERT SQL query is executed while committing transaction
		} catch (Exception e) {
			e.printStackTrace();
			HbUtil.rollbackTransaction();
		}
		System.out.println(x); 		// Detached (Removed from the session)
		*/
		
		/*
		try (BookDaoImpl dao = new BookDaoImpl()) {
			HbUtil.beginTransaction();
			Book b1 = dao.getById(11);
			System.out.println("Found: " + b1);
			if(b1 != null)
				System.out.println("Object of " + b1.getClass().getName());
			HbUtil.commitTransaction();
		} catch (Exception e) {
			e.printStackTrace();
			HbUtil.rollbackTransaction();
		}
		*/

		/*
		try (BookDaoImpl dao = new BookDaoImpl()) {
			HbUtil.beginTransaction();
			Book b2 = dao.findById(11);
			System.out.println("Found: " + b2);
			if(b2 != null)
				System.out.println("Object of " + b2.getClass().getName());
			HbUtil.commitTransaction();
		} catch (Exception e) {
			e.printStackTrace();
			HbUtil.rollbackTransaction();
		}
		*/
		
		/*
		try (BookDaoImpl dao = new BookDaoImpl()) {
			HbUtil.beginTransaction();
			Book b3 = dao.loadById(11);	// get proxy
			if(b3 != null)
				System.out.println("Object of " + b3.getClass().getName());
			System.out.println("b3 id : " + b3.getBookId());	// get id from proxy
			System.out.println("b3 name : " + b3.getTitle());	// lazy loading -- SQL -- within tx
			System.out.println("b3 author : " + b3.getAuthor());
			HbUtil.commitTransaction();
		} catch (Exception e) {
			e.printStackTrace();
			HbUtil.rollbackTransaction();
		}
		*/
		
		/*
		Book b4 = null;
		try (BookDaoImpl dao = new BookDaoImpl()) {
			HbUtil.beginTransaction();
			b4 = dao.loadById(11);	// Returns proxy containing id = 11
			System.out.println("Object of " + b4.getClass().getName());
			HbUtil.commitTransaction();
		} catch (Exception e) {
			e.printStackTrace();
			HbUtil.rollbackTransaction();
		}
		System.out.println("b4 id : " + b4.getBookId());	// Return id from the proxy
		System.out.println("b4 name : " + b4.getTitle());	// Try to execute SELECT to get the data & then getTitle()
															// will throw the exception -- due to no session available
		// if hibernate.enable_lazy_load_no_trans = true is configured, no exception is thrown.
		// instead tx is created temporarily to fetch the data.
		System.out.println("b4 author : " + b4.getAuthor());
		*/
		
		/*
		Book b5 = null;
		try (BookDaoImpl dao = new BookDaoImpl()) {
			HbUtil.beginTransaction();
			b5 = dao.loadById(101);	// Returns proxy containing id = 101
			System.out.println("Object of " + b5.getClass().getName());
			System.out.println("b5 id : " + b5.getBookId());
			System.out.println("b5 title : " + b5.getTitle()); // lazy load -- SQL -- ObjectNotFoundException
			HbUtil.commitTransaction();
		} catch (Exception e) {
			e.printStackTrace();
			HbUtil.rollbackTransaction();
		}
		*/
		
		try (BookDaoImpl dao = new BookDaoImpl()) {
			HbUtil.beginTransaction();
			Book b = new Book(54, "Yugandhar", "Shivaji", "Novell", 620);
			dao.merge(b);
			HbUtil.commitTransaction();
		} catch (Exception e) {
			e.printStackTrace();
			HbUtil.rollbackTransaction();
		}
		
		HbUtil.shutdown();
	}
}




