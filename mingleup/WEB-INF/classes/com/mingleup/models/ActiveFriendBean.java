package com.mingleup.models;

public class ActiveFriendBean {
	String username;
	String dp;
	int user_id;
	public String getUsername() {
		System.out.println("username in get "+username);
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
		System.out.println(username);
	}
	public String getDp() {
		return dp;
		
	}
	public void setDp(String dp) {
		this.dp = dp;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public ActiveFriendBean(String username, String dp, int user_id) {
		super();
		this.username = username;
		this.dp = dp;
		this.user_id = user_id;
	}
	public ActiveFriendBean() {
		super();
		// TODO Auto-generated constructor stub
	}
}
