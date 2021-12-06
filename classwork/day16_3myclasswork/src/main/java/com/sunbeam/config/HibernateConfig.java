package com.sunbeam.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@Configuration
public class HibernateConfig {
	@Value("${hibernate.dialect}")
	private String hibernateDialect;
	
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl("jdbc:mysql://localhost:3306/advjava");
		dataSource.setUsername("nilesh");
		dataSource.setPassword("nilesh");
		return dataSource;
	}

	@Bean
	public LocalSessionFactoryBean sessionFactory(DataSource dataSource) {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource);
		sessionFactory.setPackagesToScan("com.sunbeam.entities"); // scan all @Entity
		Properties props = new Properties();
		props.setProperty("hibernate.dialect", hibernateDialect);
		props.setProperty("hibernate.show_sql", "true");
		props.setProperty("hibernate.enable_lazy_load_no_trans", "true");
		sessionFactory.setHibernateProperties(props);
		return sessionFactory;
	}
	
	@Bean
	public HibernateTransactionManager transactionManager(LocalSessionFactoryBean sessionFactory) {
		HibernateTransactionManager txManager = new HibernateTransactionManager();
		txManager.setSessionFactory(sessionFactory.getObject());
		return txManager;
	}
}
