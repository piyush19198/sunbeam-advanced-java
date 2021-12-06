package com.sunbeam;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo02Main {
	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		
		BoxImpl b1 = (BoxImpl)ctx.getBean("b1");
		int result1 = b1.calcVolume();
		System.out.println("b1 Volume: " + result1);
		
		BoxImpl b2 = (BoxImpl)ctx.getBean("b2");
		int result2 = b2.calcVolume();
		System.out.println("b2 Volume: " + result2);		
	}
}