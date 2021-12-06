package tester;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestConnection {

	public static void main(String[] args) {
		//testing DB Connection
		//load Type IV JDBC Driver in JVM's meta space(method area)
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");		//We can skip loading JDBC driver as this application is standalone and only desktop application
																//We will have to load this explicitely while designing Web applicaitons
			String url = "jdbc:mysql://localhost:3306/sunbeam21?useSSL=false&allowPublicKeyRetrieval=true";
			//establishing DB Connection
			try(Connection cn = DriverManager.getConnection(url, "root", "manager")){
				System.out.println("!!!Connected to Database!!!" +" "+ cn);
			}//since Connection interface is autoclosable, cn.close() is called implicitely and DB connection is released .
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
