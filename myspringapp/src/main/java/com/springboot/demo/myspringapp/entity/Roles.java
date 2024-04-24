package com.springboot.demo.myspringapp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="roles")
public class Roles {

	@Id
	@Column(name="user_email_id")
	private String emailId;
	
	@Column(name="roles")
	private String roles;
	
	public Roles(){
		
	}

	public Roles(String emailId, String roles) {
		super();
		this.emailId = emailId;
		this.roles = roles;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}
	
	
	
}
