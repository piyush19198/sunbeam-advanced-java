package com.sunbeam;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HbUtil {
	private static SessionFactory sessionFactory=buildSessionFactory();
	
	private static SessionFactory buildSessionFactory() {
		try {
			//create configuration
			Configuration cfg = new Configuration();
			//load configuration from hibernate.cfg.xml
			cfg.configure();
			//create sessionfactory
			return cfg.buildSessionFactory();
		}catch (Exception e) {
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
