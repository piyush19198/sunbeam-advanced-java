package com.sunbeam;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
	
	@Bean(initMethod = "boxInit", destroyMethod = "boxDestroy")
	public BoxImpl b() {
		return new BoxImpl(5, 4, 3);
	}

	/*
	@Bean
	public BoxImpl box() {
		return new BoxImpl(10, 6, 8);
	}
	*/
	
	@Bean
	public BoxInfo boxInfo() {
		return new BoxInfo();
	}
}
