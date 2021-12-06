package com.sunbeam;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Demo05Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Demo05Application.class, args);
	}

	@Autowired
	private ApplicationContext ctx;

	@Override
	public void run(String... args) throws Exception {
		
		Account a1 = (Account) ctx.getBean("a1");
		System.out.println(a1);

		Account a2 = (Account) ctx.getBean("a2");
		System.out.println(a2);

		a1.deposit(3000);
		System.out.println(a1);
	}
}
