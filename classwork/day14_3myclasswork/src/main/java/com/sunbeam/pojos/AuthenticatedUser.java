package com.sunbeam.pojos;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@SessionScope
//@Scope(scopeName = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
@Component
public class AuthenticatedUser {
	private int id;
	private String name;
	private String email;
	private String role;
	public AuthenticatedUser() {
		System.out.println("AuthenticatedUser() created.");
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
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "AuthenticatedUser [id=" + id + ", name=" + name + ", email=" + email + ", role=" + role + "]";
	}
}
