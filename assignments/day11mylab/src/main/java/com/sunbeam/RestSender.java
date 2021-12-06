package com.sunbeam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RestSender implements ReadingSender {

	@Qualifier("temperatureSensor")
	
	@Autowired
	private Sensor tSensor;

	public RestSender() {}

	public Sensor gettSensor() {
		return tSensor;
	}

	public void settSensor(Sensor tSensor) {
		this.tSensor = tSensor;
	}

	@Override
	public void send() {
		int val = tSensor.readValue();
		System.out.println("Sending Over REST: " + val);
	}

}
