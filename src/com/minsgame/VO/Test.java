package com.minsgame.VO;

public class Test {
	private String userid;
	private String password;
	
	
	public Test() {

	}


	public Test(String userid, String password) {
		super();
		this.userid = userid;
		this.password = password;
	}


	public String getUserid() {
		return userid;
	}


	public void setUserid(String userid) {
		this.userid = userid;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	public String toString() {
		return String.format("Test [userid=%s, password=%s]", userid, password);
	}
	
	
	
	
	
}
