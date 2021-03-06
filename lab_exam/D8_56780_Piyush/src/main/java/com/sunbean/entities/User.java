package com.sunbean.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

//| empid | name   | email             | password |
@Entity
@Table(name = "user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int empid;
	private String name;
	private String email;
	private String password;
	@OneToMany(mappedBy = "user")
	private List<Mobile> mobList;

	@Override
	public String toString() {
		return "User [empid=" + empid + ", name=" + name + ", email=" + email + ", password=" + password + "]";
	}

	public User() {
		super();
	}

	public User(int empid, String name, String email, String password) {
		super();
		this.empid = empid;
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public int getEmpid() {
		return empid;
	}

	public void setEmpid(int empid) {
		this.empid = empid;
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
}
