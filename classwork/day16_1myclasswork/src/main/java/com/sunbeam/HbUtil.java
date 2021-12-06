package com.sunbeam;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HbUtil {
	private static SessionFactory sessionFactory = buildSessionFactory();
	private static StandardServiceRegistry serviceRegistry;
	
	private static SessionFactory buildSessionFactory() {
		// Hibernate 5 bootstrapping -- Lab time
		try {
			// Create ServiceRegistry using builder pattern
			serviceRegistry = new StandardServiceRegistryBuilder()
				.configure() // read hibernate.cfg.xml
				.build();
			// Create Metadata using builder pattern
			Metadata metadata = new MetadataSources(serviceRegistry)
				.getMetadataBuilder()
				.build();
			// Create SessionFactory
			return metadata.buildSessionFactory();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
		return null;
	}
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public static void shutdown() {
		sessionFactory.close();
	}

	public static Session getSession() {
		Session session = sessionFactory.getCurrentSession();
		return session;
	}
	
	public static void beginTransaction() {
		Session session = sessionFactory.getCurrentSession();
		session.getTransaction().begin();
	}
	public static void commitTransaction() {
		Session session = sessionFactory.getCurrentSession();
		session.getTransaction().commit();
	}
	public static void rollbackTransaction() {
		Session session = sessionFactory.getCurrentSession();
		session.getTransaction().rollback();
	}
}

