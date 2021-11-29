package com.sunbeam;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
	@Bean
	public AccountImpl acc() {
		AccountImpl a = new AccountImpl(101, "Saving", 10000);
		return a;
	}
	
	@Bean
	public ConsoleLoggerImpl consoleLogger() {
		return new ConsoleLoggerImpl();
	}

	@Bean
	public FileLoggerImpl fileLogger() {
		return new FileLoggerImpl();
	}
	
	@Bean
	public PersonImpl p1() {
		PersonImpl p = new PersonImpl();
		p.setName("Alpha");
		p.setAge(25);
		p.setEmail("alpha@gmail.com");
		return p;
	}
	
	@Bean
	public PersonImpl p2() {
		return new PersonImpl("Beta",30,"beta@gmail.com");
	}
}
