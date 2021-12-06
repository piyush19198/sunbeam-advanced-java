package com.sunbeam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Day121myclassworkApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Day121myclassworkApplication.class, args);
	}

	@Autowired
	private ApplicationContext ctx;
	
	@Override
	public void run(String... args) throws Exception {
		Box b1a = (Box) ctx.getBean("b1");
		Box b1b = (Box) ctx.getBean("b1");
		System.out.println("Single b1 Object is created: " + (b1a == b1b));
		
		Box b2a = (Box) ctx.getBean("b2");
		Box b2b = (Box) ctx.getBean("b2");
		System.out.println("Single b2 Object is created: " + (b2a == b2b));
	}
}

