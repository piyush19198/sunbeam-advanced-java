package com.sunbeam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Day11mylabApplication implements CommandLineRunner {
	public static void main(String[] args) {
		SpringApplication.run(Day11mylabApplication.class, args);
	}

	@Autowired
	ApplicationContext ctx;

	@Qualifier("restSender")
	@Autowired
	private ReadingSender restSender;

	@Qualifier("soapSender")

	@Autowired
	private ReadingSender soapSender;

	@Override
	public void run(String... args) throws Exception {
		ReadingSender httpSender = (ReadingSender) ctx.getBean(HttpSender.class);
		httpSender.send();
		ReadingSender tcpSender = (ReadingSender) ctx.getBean("tcpSender");
		tcpSender.send();
		restSender.send();
		soapSender.send();
	}
}