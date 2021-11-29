package com.sunbeam.beans;

import com.sunbeam.daos.LoginDaoImpl;
import com.sunbeam.pojos.User;

public class UserBean {
	private String email;
	private String password;
	private User user;
	public UserBean() {
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public void validateUser() {
		try(LoginDaoImpl dao = new LoginDaoImpl()){
			user = dao.authenticate(email, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}