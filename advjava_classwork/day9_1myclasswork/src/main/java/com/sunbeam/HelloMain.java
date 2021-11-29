package com.sunbeam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class HelloMain {

	private static final String DB_URL = "jdbc:mysql://localhost:3306/sunbeam21";
	private static final String DB_NAME = "root";
	private static final String DB_PASSWORD = "manager";

	public static void main(String[] args) {
		System.out.println("Hello Maven");

		String sql = "select id,name from topics";
		try (Connection con = DriverManager.getConnection(DB_URL, DB_NAME, DB_PASSWORD)) {
			try (PreparedStatement stmt = con.prepareStatement(sql)) {
				try (ResultSet rs = stmt.executeQuery()) {
					while (rs.next()) {
						int id = rs.getInt("id");
						String name = rs.getString("name");
						System.out.println(id + " , " + name);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
