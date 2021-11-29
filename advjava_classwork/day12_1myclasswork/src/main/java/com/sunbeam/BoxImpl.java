package com.sunbeam;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class BoxImpl implements Box, BeanNameAware {
	private int length;
	private int breadth;
	private int height;
	public BoxImpl() {
		System.out.println("BoxImpl() called");
	}
	public BoxImpl(int length, int breadth, int height) {
		this.length = length;
		this.breadth = breadth;
		this.height = height;
		System.out.println("BoxImpl(int,int,int) called");
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		System.out.println("BoxImpl.setLength() called");
		this.length = length;
	}
	public int getBreadth() {
		return breadth;
	}
	public void setBreadth(int breadth) {
		System.out.println("BoxImpl.setBreadth() called");
		this.breadth = breadth;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		System.out.println("BoxImpl.setHeight() called");
		this.height = height;
	}
	@Override
	public String toString() {
		return "BoxImpl [length=" + length + ", breadth=" + breadth + ", height=" + height + "]";
	}
	@Override
	public int calcVolume() {
		System.out.println(this.beanName+".BoxImpl.calcVolume() called");
		return this.length * this.breadth * this.height;
	}
	@Override
	public int calcSurfaceArea() {
		System.out.println(this.beanName+".BoxImpl.calcSurfaceArea() called");
		return 2 * (this.length * this.breadth + this.breadth * this.height + this.length * this.height);
	}
	
	private String beanName;
	@Override
	public void setBeanName(String name) {
		this.beanName = name;
	}

	@PostConstruct
	public void boxPostConstruct() {
		System.out.println(this.beanName + ".BoxImpl.boxPostConstruct() called.");
	}

	@PreDestroy
	public void boxPreDestroy() {
		System.out.println(this.beanName + ".BoxImpl.boxPreDestroy() called.");
	}
}
