package tester;
import java.sql.*;
import static utils.DBUtils.fetchConnection;

public class TestDBUtils {
	public static void main(String[] args) {
		try(Connection cn = fetchConnection()) {
			//Connection cn1 = fetchConnection();
			//Connection cn2 = fetchConnection();
							
			System.out.println("Connected to DB " + cn);
			//System.out.println("Connected to DB " + cn1);
			//System.out.println("Connected to DB " + cn2); //will show same connection ID as it is singleton connection instance
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
