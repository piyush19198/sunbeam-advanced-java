package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import static utils.DBUtils.fetchConnection;

import pojos.User;

public class UserDaoImpl implements IUserDao {

	private Connection cn;
	private PreparedStatement pst1;
	private PreparedStatement pst2;
	
	public UserDaoImpl() throws ClassNotFoundException,SQLException {
		cn = fetchConnection();
		pst1 = cn.prepareStatement("select * from users where name=? and password=?");
		pst2 = cn.prepareStatement("update users set password=? where email=? and password=?");
	}
	
	@Override
	public User authenticateUser(String name, String password) throws SQLException {
		pst1.setString(1, name);
		pst1.setString(2, password);
		
		try (ResultSet rst = pst1.executeQuery()) {
			if (rst.next()) 
				return new User(rst.getInt(1), rst.getString(2), name, password, rst.getDouble(5), rst.getDate(6), rst.getString(7));
		}
		return null;
	}
	
	public void cleanUp() throws SQLException {
		if (pst1 != null)
			pst2.close();
		if (pst1 != null)
			pst2.close();
	}

	@Override
	public String updatePassword(String email,String password,String newPassword) throws SQLException{
		pst2.setString(1,newPassword);
		pst2.setString(2,email);
		pst2.setString(3, password);
		int updateCount = pst2.executeUpdate();
		if(updateCount == 1)
			return "PASSWORD UPDATED SUCCESSFULLY";
		return "FAILED TO UPDATE PASSWORD";
	}

}
