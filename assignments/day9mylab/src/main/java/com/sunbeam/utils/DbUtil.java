package com.sunbeam.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbUtil {
	private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String DB_URL = "jdbc:mysql://localhost:3306/sunbeam21";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "snakendswords";

	static {
		try {
			Class.forName(DB_DRIVER);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws Exception {
		return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
	}
}

