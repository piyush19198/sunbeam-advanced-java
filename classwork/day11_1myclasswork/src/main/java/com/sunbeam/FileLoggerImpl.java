package com.sunbeam;

import java.io.FileOutputStream;
import java.io.PrintStream;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Component
public class FileLoggerImpl implements Logger {
	@Value("${log.filePath}")
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
			try (PrintStream pout = new PrintStream(out)) {
				pout.println(message);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
