package com.sunbeam.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.sunbeam.pojos.User;
import com.sunbeam.utils.DbUtil;

public class LoginDaoImpl implements AutoCloseable {
	private Connection con;

	public LoginDaoImpl() throws Exception {
		con = DbUtil.getConnection();
	}
	public void close() {
		try {
			if (con != null)
				con.close();
		} catch (Exception e) {
		}
	}

	public User authenticate(String email, String password) throws Exception {
		String sql = "SELECT id, name, email, password, reg_amt, reg_date, role FROM users WHERE email = ? AND password = ?";
		try(PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setString(1, email);
			stmt.setString(2, password);
			try(ResultSet rs = stmt.executeQuery()) {
				if(rs.next()) {
					User user = new User();
					user.setId(rs.getInt("id"));
					user.setName(rs.getString("name"));
					user.setEmail(rs.getString("email"));
					user.setPassword(rs.getString("password"));
					user.setRegAmount(rs.getDouble("reg_amt"));
					user.setRegDate(rs.getDate("reg_date"));
					user.setEmail(rs.getString("email"));
					user.setRole(rs.getString("role"));
					return user;
				}
			}
		}
		return null;
	}
}