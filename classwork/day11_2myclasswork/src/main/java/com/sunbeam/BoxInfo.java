package com.sunbeam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

public class BoxInfo {
	//@Autowired
	@Value("#{b}")
	private Box box;
	@Value("#{b.length}")
	private int length;
	@Value("#{b.breadth}")
	private int breadth;
	@Value("#{b.height}")
	private int height;
	@Value("#{b.calcVolume()}")
	private int volume;
	@Value("#{b.calcSurfaceArea()}")
	private int surfaceArea;
	@Value("#{4 * (b.length + b.breadth + b.height)}")
	private int perimeter;
	
	public BoxInfo() {
		System.out.println("BoxInfo() called");
	}
	public Box getBox() {
		return box;
	}
	public void setBox(Box box) {
		this.box = box;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public int getBreadth() {
		return breadth;
	}
	public void setBreadth(int breadth) {
		this.breadth = breadth;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getVolume() {
		return volume;
	}
	public int getSurfaceArea() {
		return surfaceArea;
	}
	public int getPerimeter() {
		return perimeter;
	}
	@Override
	public String toString() {
		return "BoxInfo [box=" + box + ", length=" + length + ", breadth=" + breadth + ", height=" + height
				+ ", volume=" + volume + ", surfaceArea=" + surfaceArea + ", perimeter=" + perimeter + "]";
	}

}
