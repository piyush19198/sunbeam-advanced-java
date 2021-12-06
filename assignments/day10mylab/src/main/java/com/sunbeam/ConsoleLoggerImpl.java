package com.sunbeam;

public class ConsoleLoggerImpl implements Logger {
	@Override
	public void log(String message) {
		System.out.println(message);
	}
}
