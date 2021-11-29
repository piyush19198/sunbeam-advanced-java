package com.sunbeam;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class TemperatureSensor implements Sensor {
	
	Random randumNumber = new Random();

	@Override
	public int readValue() {
		return (randumNumber.nextInt(21) + 10);
	}

}
