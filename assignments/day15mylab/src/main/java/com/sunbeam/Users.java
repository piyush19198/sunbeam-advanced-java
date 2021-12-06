package com.sunbeam;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "users")
public class Users {
	
	private int id;
	private String name;
	private String email;
	private String password;
	private double reg_amt;
	private Date date;
	private String role;
	public Users() {
	}
	public Users(int id, String name, String email, String password, double reg_amt, Date date, String role) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.reg_amt = reg_amt;
		this.date = date;
		this.role = role;
	}
	@Id
	@Column(name="id")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Column(name="name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(name="email")
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Column(name="password")
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Column(name="reg_amt")
	public double getReg_amt() {
		return reg_amt;
	}
	public void setReg_amt(double reg_amt) {
		this.reg_amt = reg_amt;
	}
	@Column(name="reg_date")
	@Temporal(TemporalType.DATE)
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@Column(name="role")
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		System.out.println("In Users toString");
		return "Users [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", reg_amt="
				+ reg_amt + ", date=" + date + ", role=" + role + "]";
	}
	
	
}
