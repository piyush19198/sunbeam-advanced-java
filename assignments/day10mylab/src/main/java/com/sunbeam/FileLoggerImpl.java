package com.sunbeam;

import java.io.FileOutputStream;
import java.io.PrintStream;

public class FileLoggerImpl implements Logger {
	private String logFilePath;
	public FileLoggerImpl() {
		this.logFilePath = "default.txt";
	}
	public FileLoggerImpl(String logFilePath) {
		this.logFilePath = logFilePath;
	}
	public String getLogFilePath() {
		return logFilePath;
	}
	public void setLogFilePath(String logFilePath) {
		this.logFilePath = logFilePath;
	}
	@Override
	public void log(String message) {
		try (FileOutputStream out = new FileOutputStream(logFilePath, true)) {
			try(PrintStream pout = new PrintStream(out)) {
				pout.println(message);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
