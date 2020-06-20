package com.codenotfound.primefaces.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "Account")
public class Account {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String username;
	private String password;
	private boolean admin = false;
	private int [] cart;
	
	public boolean isAdmin() {
		return admin;
	}
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Account(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public Account() {
		super();
	}

}