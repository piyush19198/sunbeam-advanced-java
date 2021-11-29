package com.sunbeam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SoapSender implements ReadingSender {

	@Qualifier("humiditySensor")
	@Autowired
	private Sensor tSensor;

	public SoapSender() {}

	public Sensor gettSensor() {
		return tSensor;
	}

	public void settSensor(Sensor tSensor) {
		this.tSensor = tSensor;
	}

	@Override
	public void send() {
		int val = tSensor.readValue();
		System.out.println("Sending Over SOAP: " + val);
	}

}
