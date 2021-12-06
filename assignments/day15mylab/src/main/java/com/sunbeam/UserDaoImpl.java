package com.sunbeam;

import java.util.List;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class UserDaoImpl implements AutoCloseable{
	private Session session;

	public UserDaoImpl() {
		SessionFactory factory = HbUtil.getSessionFactory();
		session=factory.openSession();
	}
	@Override
	public void close() throws Exception {
		if(session!=null)
			session.close();
		
		
	}
	String hql = "SELECT u FROM Users u";
	
	public Users findById(int id) {
		Users user = session.get(Users.class, id);
		System.out.println(user);
		return user;
	}
	
	public List<Users> findAll() {
		Query<Users> userList = session.createQuery(hql);
		return userList.getResultList();
	}
	
	public void update(Users user) {
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			if(user != null) {
				user.setPassword("123456");
				user.setName("ShakeHer");
				session.update(user);
			}
			tx.commit();
		}catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
	}
	
	public void deleteById(int id) {
		Transaction tx = null;
		Users user1 = session.get(Users.class, id);  
		try {
			tx = session.beginTransaction();
			if(user1!=null) {
				session.delete(user1);
			}
			tx.commit();
		}catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
	}
	
	public void save(Users user) {
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			if(user!=null) {
				session.persist(user);
			}
			tx.commit();
		}catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
	}
}
