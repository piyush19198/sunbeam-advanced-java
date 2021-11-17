package tester;

import static utils.DBUtils.fetchConnection;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class TestPreparedStatement {
	public static void main(String[] args) {
		String sql="select empid,name,salary,join_date from my_emp where deptid=? and join_date between ? and ?";
		try(Scanner sc = new Scanner(System.in);
				Connection cn = fetchConnection();
				PreparedStatement pst = cn.prepareStatement(sql);) {
				System.out.println("Enter department id , start date(yr-month-day), end date");
				pst.setString(1,sc.next());
				pst.setDate(2, Date.valueOf(sc.next()));
				pst.setDate(3, Date.valueOf(sc.next()));
				try(ResultSet rst = pst.executeQuery()) {
					while(rst.next())
						System.out.printf("EMP ID %d NAME %s SALARY %.1f JOIN DATE %s %n",
								rst.getInt(1),rst.getString(2),rst.getDouble(3),rst.getDate(4));
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
