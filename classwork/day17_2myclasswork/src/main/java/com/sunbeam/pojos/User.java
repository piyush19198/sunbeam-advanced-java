package com.sunbeam.pojos;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

// MySQL> CREATE TABLE ids(entity CHAR(20), id INT);
/*
// Topic entity
@TableGenerator(name = "g", table = "ids", pkColumnName = "entity", pkColumnValue = "topic", valueColumnName = "id", initialValue = 200)
@GeneratedValue(generator = "g", strategy = GenerationType.TABLE)

// Tutorial entity
@TableGenerator(name = "g", table = "ids", pkColumnName = "entity", pkColumnValue = "tutorial", valueColumnName = "id", initialValue = 300)
@GeneratedValue(generator = "g", strategy = GenerationType.TABLE)
*/

@Entity
@Table(name = "users")
public class User {
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	/*
	@SequenceGenerator(name = "g", sequenceName = "user_seq")
	@GeneratedValue(generator = "g", strategy = GenerationType.SEQUENCE)
	*/
	/*
	@TableGenerator(name = "g", table = "ids", pkColumnName = "entity", pkColumnValue = "user", valueColumnName = "id", initialValue = 100, allocationSize = 1)
	@GeneratedValue(generator = "g", strategy = GenerationType.TABLE)
	*/
	private int id;
	@Column
	private String name;
	@Column
	private String email;
	@Column
	private String password;
	@Column(name="reg_amt")
	private double regAmount;
	@Temporal(TemporalType.DATE)
	@Column(name="reg_date")
	private Date regDate;
	@Column
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
