package com.lec.commerce.web;

import java.util.Date;

public class User {

	private int id;
	private String fname;
	private String lname;
	private String email;
	private String password;
	private String username;
	private int status;
	private Date testdate;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
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
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Date getTestdate() {
		return testdate;
	}
	public void setTestdate(Date testdate) {
		this.testdate = testdate;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", fname=" + fname + ", lname=" + lname + ", email=" + email + ", password="
				+ password + ", username=" + username + ", status=" + status + ", testdate=" + testdate + "]";
	}
	
	
	
	
	
	
}
