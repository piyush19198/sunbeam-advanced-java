package com.sunbeam;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@SpringBootApplication(exclude = { 
		HibernateJpaAutoConfiguration.class, 
		DataSourceAutoConfiguration.class, 
		DataSourceTransactionManagerAutoConfiguration.class 
	})
public class Day171myclassworkApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Day171myclassworkApplication.class, args);
	}
	
	@Autowired
	private BookDao bookDao;
	
	@Override
	public void run(String... args) throws Exception {
		try {
			Book b = new Book(55, "Atlas Shrugged", "Ayn Rand", "Novell", 572.93);
			bookDao.save(b);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
 			Book b = bookDao.findById(55);
 			System.out.println("Book Found: " + b);
 			if(b != null) {
 				b.setPrice(853.34);
 				bookDao.update(b);
 			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
 			bookDao.deleteById(55);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
 			List<Book> list = bookDao.findAll();
 			list.forEach(System.out::println);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
