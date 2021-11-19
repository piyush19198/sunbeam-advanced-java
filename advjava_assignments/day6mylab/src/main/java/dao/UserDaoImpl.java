package dao;

import java.sql.*;
import static utils.DBUtils.fetchConnection;

import pojos.User;

public class UserDaoImpl implements IUserDao {
	private Connection cn;
	private PreparedStatement pst1;

	public UserDaoImpl() throws ClassNotFoundException, SQLException {
		// get cn
		cn = fetchConnection();
		pst1 = cn.prepareStatement("select * from users where email=? and password=?");
		System.out.println("user dao created");
	}

	@Override
	public User validateUser(String email, String pwd) throws SQLException {
		// set IN params
		pst1.setString(1, email);
		pst1.setString(2, pwd);
		try (ResultSet rst = pst1.executeQuery()) {
			if (rst.next()) // valid login
				// int userId, String name, String email, String password, double regAmount,
				// Date regDate, String role) {
				return new User(rst.getInt(1), rst.getString(2), email, pwd, rst.getDouble(5), rst.getDate(6),
						rst.getString(7));

		}

		return null;//invalid login
	}

	public void cleanUp() throws SQLException {
		if (pst1 != null)
			pst1.close();
		System.out.println("user dao cleaned up!");
	}

}
