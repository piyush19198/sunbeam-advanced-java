package com.sunbean.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//| id | companyname | model | price |

@Entity
@Table(name = "mobile")
public class Mobile {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String companyname;
	private String model;
	private String price;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "mid")
	private User user;

	@Override
	public String toString() {
		return "Mobile [id=" + id + ", companyname=" + companyname + ", model=" + model + ", price=" + price + "]";
	}

	public Mobile() {
		super();
	}

	public Mobile(int id, String companyname, String model, String price) {
		super();
		this.id = id;
		this.companyname = companyname;
		this.model = model;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCompanyname() {
		return companyname;
	}

	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
