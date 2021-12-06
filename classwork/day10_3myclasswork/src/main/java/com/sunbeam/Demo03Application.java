package com.sunbeam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Demo03Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Demo03Application.class, args);
	}

	@Autowired
	private ApplicationContext ctx;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Hello, Spring Boot!");

		BoxImpl b1 = (BoxImpl) ctx.getBean("b1");
		int result1 = b1.calcVolume();
		System.out.println("b1 Volume: " + result1);

		BoxImpl b2 = (BoxImpl) ctx.getBean("b2");
		int result2 = b2.calcVolume();
		System.out.println("b2 Volume: " + result2);
	}
}