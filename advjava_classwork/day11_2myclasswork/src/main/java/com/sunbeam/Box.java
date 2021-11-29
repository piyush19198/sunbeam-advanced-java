package com.sunbeam;

public interface Box {
	int getLength();
	int getBreadth();
	int getHeight();
	void setLength(int length);
	void setBreadth(int breadth);
	void setHeight(int height);
	int calcVolume();
	int calcSurfaceArea();
}

