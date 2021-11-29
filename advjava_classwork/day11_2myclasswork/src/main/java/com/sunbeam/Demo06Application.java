package com.sunbeam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Demo06Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Demo06Application.class, args);
	}

	@Autowired
	private ApplicationContext ctx;
	
	@Override
	public void run(String... args) throws Exception {
		/*
		Box b = ctx.getBean(Box.class);
		System.out.println(b);
		
		BoxInfo info = ctx.getBean(BoxInfo.class);
		System.out.println(info);
		*/
		
		System.out.println("Bye!");
	}
}
