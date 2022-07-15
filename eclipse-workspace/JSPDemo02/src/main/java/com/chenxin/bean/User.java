package com.chenxin.bean;

public class User {
	private int uid;
	private String uname;
	private String upassword;
	
	public User (String uname,String upassword) {
		this.uname = uname;
		this.upassword = upassword;
	}
	
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	
	public String getUpassword() {
		return upassword;
	}
	public void setUpassword(String upassword) {
		this.upassword = upassword;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}
	
	
}
