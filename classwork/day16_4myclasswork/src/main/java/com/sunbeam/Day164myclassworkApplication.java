package com.sunbeam;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sunbeam.entities.Book;
import com.sunbeam.services.BookServiceImpl;

@SpringBootApplication
public class Day164myclassworkApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Day164myclassworkApplication.class, args);
	}

	@Autowired
	private BookServiceImpl bookService;
	
	@Override
	public void run(String... args) throws Exception {
		List<Book> list = bookService.findAllBooks();
		list.forEach(System.out::println);
		System.out.println();
		
		Book b = new Book(61, "Apurwai", "PL Deshpande", "Novell", 623.0);
		bookService.saveBook(b);
		System.out.println();
		
		b = bookService.findBookById(61);
		System.out.println(b);
		System.out.println();
		
		bookService.deleteBookById(61);
		System.out.println();
		
		list = bookService.findBookBySubject("C");
		list.forEach(System.out::println);
		System.out.println();
		
		list = bookService.findBookBySubjectAndAuthor("C", "KANETKAR");
		list.forEach(System.out::println);
		System.out.println();
		
		list = bookService.findBookByPriceGreaterThanOrderByPriceDesc(500);
		list.forEach(System.out::println);
		System.out.println();
		
		list = bookService.findBookByTitleContaining("Programming");
		list.forEach(System.out::println);
		System.out.println();
	}
}
