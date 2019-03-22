package com.slk.entity;

public class Userdata {
	
	private String fname;
	private String lname;
	private String email;
	private String uname;
	private String password;
	public Userdata(String fname, String lname, String email, String uname, String password) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.uname = uname;
		this.password = password;
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
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Userdata [fname=" + fname + ", lname=" + lname + ", email=" + email + ", uname=" + uname + ", password="
				+ password + "]";
	}
	
	
}
