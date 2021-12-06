package com.sunbeam;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {
	@Scope("singleton")
	@Bean
	public BoxImpl b1() {
		BoxImpl b1 = new BoxImpl();
		b1.setLength(5);
		b1.setBreadth(4);
		b1.setHeight(3);
		return b1;
	}

	@Scope("prototype")
	@Bean
	public BoxImpl b2() {
		BoxImpl b2 = new BoxImpl();
		b2.setLength(10);
		b2.setBreadth(6);
		b2.setHeight(8);
		return b2;
	}
}
