package com.sunbeam;

import org.springframework.stereotype.Component;

@Component
public interface Sensor {
	public int readValue();
}
