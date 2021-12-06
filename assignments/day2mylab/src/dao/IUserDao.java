package dao;

import java.sql.SQLException;

import pojos.User;

public interface IUserDao {
	User authenticateUser(String email,String password) throws SQLException;
	
	String updatePassword (String email, String password, String newPassword) throws SQLException;
}
