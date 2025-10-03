package com.rays.bean;

import java.util.Date;

public class UserBean {
	
	private int id;
	private String firstName;
	private String LastName;
	private String login;
	private String password;
	private Date dob;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getdob() {
		return dob;
	}
	public void setdob(Date dob) {
		this.dob = dob;
	}
	
	

}
