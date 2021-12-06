package com.sunbeam.pojos;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class Credentials {
	@Email //(message = "invalid email.")
	@NotBlank
	private String email; // name must be same as req param (i.e. html control)
	@Size(min = 3)
	@NotBlank
	private String password; // name must be same as req param (i.e. html control)
	
	public Credentials() {
	}
	public Credentials(String email, String password) {
		this.email = email;
		this.password = password;
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
	@Override
	public String toString() {
		return "Credentials [email=" + email + ", password=" + password + "]";
	}
}
