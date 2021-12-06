package com.sunbeam;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class HumiditySensor implements Sensor {
	
	Random randumNumber = new Random();

	@Override
	public int readValue() {
		return (randumNumber.nextInt(61) + 40);
	}

}
