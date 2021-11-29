package com.sunbeam;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@ComponentScan({ "com.cdac", "com.dac" })
@PropertySource("classpath:demo.properties")
@Configuration
public class AppConfig {
	@ConfigurationProperties(prefix = "acc1")
	@Bean
	public AccountImpl a1() {
		return new AccountImpl();
	}

	@ConfigurationProperties(prefix = "acc2")
	@Bean
	public AccountImpl a2() {
		return new AccountImpl();
	}
}
