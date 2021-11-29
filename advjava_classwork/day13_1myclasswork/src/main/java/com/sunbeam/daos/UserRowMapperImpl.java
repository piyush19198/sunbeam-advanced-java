package com.sunbeam.daos;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.sunbeam.pojos.User;

public class UserRowMapperImpl implements RowMapper<User> {
	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		// ResultSet ---> User object
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




