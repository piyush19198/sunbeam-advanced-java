package com.sunbeam;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo01Main {
	public static void main(String[] args) {
		/*
		 * BoxImpl b1 = new BoxImpl(); b1.setLength(5); b1.setBreadth(4);
		 * b1.setHeight(3); int result1 = b1.calcVolume();
		 * System.out.println("b1 Volume: " + result1);
		 * 
		 * BoxImpl b2 = new BoxImpl(10, 8, 6); int result2 = b2.calcVolume();
		 * System.out.println("b2 Volume: " + result2);
		 */
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		
		BoxImpl b1 = (BoxImpl) ctx.getBean("b1");
		int result1 = b1.calcVolume();
		System.out.println("b1 Volume: " + result1);

		BoxImpl b2 = (BoxImpl) ctx.getBean("b2");
		int result2 = b2.calcVolume();
		System.out.println("b2 Volume: " + result2);
	}
}