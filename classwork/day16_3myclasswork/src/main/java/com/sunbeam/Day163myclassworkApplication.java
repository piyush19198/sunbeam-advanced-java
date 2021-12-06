package com.sunbeam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sunbeam.entities.Book;
import com.sunbeam.services.BookServiceImpl;

@SpringBootApplication
public class Day163myclassworkApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Day163myclassworkApplication.class, args);
	}

	@Autowired
	private BookServiceImpl bookService;
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println("Spring Boot + Hibernate Demo");
	
		Book x = new Book(51, "Abc", "Pqr", "Novell", 100.0);
		bookService.save(x);
		
		Book b = bookService.findById(51);
		System.out.println("Found: " + b);
	}
}