package com.sunbeam;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HbUtil {
	private static SessionFactory sessionFactory = buildSessionFactory();
	
	private static SessionFactory buildSessionFactory() {
		// Hibernate 5 bootstrapping -- Lab time
		try {
			// create Configuration
			Configuration cfg = new Configuration();
			// Load configuration from hibernate.cfg.xml
			cfg.configure();
			// create sessionFactory
			return cfg.buildSessionFactory();
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
}

