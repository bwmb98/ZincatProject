package com.example.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userid;
	
	@Column(nullable = false, unique = true, length = 45)
	private String email;
	
	@Column(nullable = false, length = 45)
	private String firstname;
	
	@Column(nullable = false, length = 45)
	private String lastname;
	
	@Column(nullable = false, length = 60)
	private String password;
	
	public User() {
		
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User(int userid, String email, String firstname, String lastname, String password) {
		super();
		this.userid = userid;
		this.email = email;
		this.firstname = firstname;
		this.lastname = lastname;
		this.password = password;
	}

	
	
}
