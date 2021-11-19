package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {
	private static Connection cn;

	public static Connection fetchConnection() throws SQLException {
		
		return cn;
	}

	public static void closeConnection() throws SQLException {
		if (cn != null)
			cn.close();
	}

	public static void openConnection(String url, String userName, String pass) throws SQLException {
		if (cn == null)
			cn = DriverManager.getConnection(url, userName, pass);
	}
}
