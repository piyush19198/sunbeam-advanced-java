package com.sunbeam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Demo04Application implements CommandLineRunner {

	public static void main(String... args) {
		SpringApplication.run(Demo04Application.class, args);
	}

	@Autowired
	private ApplicationContext ctx;

	@Override
	public void run(String... args) throws Exception {
		Account acc = (Account) ctx.getBean("acc");
//		Logger consoleLogger = (Logger) ctx.getBean("consoleLogger");
//		Logger fileLogger = (Logger) ctx.getBean("fileLogger");
//		
//		acc.setLogger(fileLogger);
//		
//		System.out.println("ACC " + acc);
//		acc.deposit(3000);
//		System.out.println("ACC " + acc);
		
		Person person1 = (Person) ctx.getBean("p1");
		Person person2 = (Person) ctx.getBean("p2");
		acc.setAccHolder(person1);
		System.out.println("Person : "+acc);
		acc.setAccHolder(person2);
		System.out.println("Person : "+acc);
	}
}



