package com.springboot.demo.myspringapp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name ="app_users")
public class AppUsers {

	@Id
	@Column(name="userId")
	private String email;
	
	@Column(name="password")
	private String userPassword;
	
	@Column(name="name")
	private String fullName;
	
	public AppUsers(){
		
	}

	public AppUsers(String email, String userPassword, String fullName) {
		super();
		this.email = email;
		this.userPassword = userPassword;
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	
}
