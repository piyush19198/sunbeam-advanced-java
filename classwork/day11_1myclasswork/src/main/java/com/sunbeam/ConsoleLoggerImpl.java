package com.sunbeam;

import org.springframework.stereotype.Component;

@Component 
public class ConsoleLoggerImpl implements Logger {
	@Override
	public void log(String message) {
		System.out.println(message);
	}
}
