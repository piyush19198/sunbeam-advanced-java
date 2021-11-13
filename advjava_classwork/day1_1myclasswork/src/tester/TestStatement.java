package tester;
import java.sql.*;
import static utils.DBUtils.fetchConnection;

public class TestStatement {
	public static void main(String[] args) {
		try(	Connection cn = fetchConnection();
				Statement st = cn.createStatement();							//create empty statement object from Connection
				ResultSet rst = st.executeQuery("select*from my_emp");			//execute select statement and get ResultSet object
				) {		
				while(rst.next()) {
					// read and display row data
					System.out.printf("Emp Id %d Name %s Address %s Sal %.1f Dept %s Join Date %s %n",
							rst.getInt(1),rst.getString(2),rst.getString(3),rst.getDouble(4),rst.getString(5),rst.getDate(6));
				}
		}catch (Exception e) {		//rst.close st.close cn.close will be called implicitely since autoclosable nature
			e.printStackTrace();
		}
	}
}
