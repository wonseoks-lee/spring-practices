package com.poscoict.container.user;

import java.util.List;

public class User {
	private String name = "이원석";
	private Long no = 0L;
	private Friend friend = null;
	private List<String> friends;
	
	public void setFriends(List<String> friends) {
		this.friends = friends;
	}


	public User() {
		
	}
	
	
	public User(String name) {
		this.name=name;
	}
	
	public User(Long no, String name) {
		this.no=no;
		this.name=name;
	}
	
	
	public void setFriend(Friend friend) {
		this.friend = friend;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setNo(Long no) {
		this.no = no;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", no=" + no + ", friend=" + friend + ", friends=" + friends + "]";
	}

	
	
	
}
