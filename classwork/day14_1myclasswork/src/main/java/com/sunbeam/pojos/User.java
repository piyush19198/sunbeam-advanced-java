package com.sunbeam.pojos;

import java.sql.Date;

public class User {
	private int id;
	private String name;
	private String email;
	private String password;
	private double regAmount;
	private Date regDate;
	private String role;
	
	public User() {
	}

	public User(int id, String name, String email, String password, double regAmount, Date regDate, String role) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.regAmount = regAmount;
		this.regDate = regDate;
		this.role = role;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public double getRegAmount() {
		return regAmount;
	}

	public void setRegAmount(double regAmount) {
		this.regAmount = regAmount;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return String.format("User [id=%s, name=%s, email=%s, password=%s, regAmount=%s, regDate=%s, role=%s]", id,
				name, email, password, regAmount, regDate, role);
	}
}
