package com.sunbeam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Primary
@Configuration
public class HttpSender implements ReadingSender {

	@Qualifier("humiditySensor")
	@Autowired
	private Sensor tSensor;

	public HttpSender() {}

	public Sensor gettSensor() {
		return tSensor;
	}

	public void settSensor(Sensor tSensor) {
		this.tSensor = tSensor;
	}

	@Override
	public void send() {
		int val = tSensor.readValue();
		System.out.println("Sending Over HTTP: " + val);
	}

}
