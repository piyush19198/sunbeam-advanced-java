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
}
