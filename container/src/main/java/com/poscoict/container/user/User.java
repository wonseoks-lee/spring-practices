package com.poscoict.container.user;

public class User {
	private String name = "이원석";
	private Long no = 0L;
	public User() {
		
	}

	public User(String name) {
		this.name=name;
	}
	
	public User(Long no, String name) {
		this.no=no;
		this.name=name;
	}
	
	
	
	public void setName(String name) {
		this.name = name;
	}

	public void setNo(Long no) {
		this.no = no;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", no=" + no + "]";
	}

	
	
	
}
