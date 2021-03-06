package com.sunbeam.pojos;

import java.sql.Date;

public class Vendor {

	private int id;
	private String name;
	private String email;
	private String password;
	private String city;
	private String role;
	private String cellNo;
	private double regAmount;
	private Date date;

	public Vendor() {
		super();
	}

	public Vendor(int id, String name, String email, String password, String city, String role, String cellNo,
			double regAmount, Date date) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.city = city;
		this.role = role;
		this.cellNo = cellNo;
		this.regAmount = regAmount;
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getCellNo() {
		return cellNo;
	}

	public void setCellNo(String cellNo) {
		this.cellNo = cellNo;
	}

	public double getRegAmount() {
		return regAmount;
	}

	public void setRegAmount(double regAmount) {
		this.regAmount = regAmount;
	}

	@Override
	public String toString() {
		return "Vendor [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", city=" + city
				+ ", role=" + role + ", cellNo=" + cellNo + ", regAmount=" + regAmount + ", date=" + date + "]";
	}

}
