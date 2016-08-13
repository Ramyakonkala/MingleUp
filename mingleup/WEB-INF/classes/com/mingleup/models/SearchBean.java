package com.mingleup.models;

public class SearchBean {
	String friendName;
	int friendId;
	public String getFriendName() {
		return friendName;
	}
	public void setFriendName(String friendName) {
		this.friendName = friendName;
	}
	public int getFriendId() {
		return friendId;
	}
	public void setFriendId(int friendId) {
		this.friendId = friendId;
	}
	public SearchBean(String friendName, int friendId) {
		super();
		this.friendName = friendName;
		this.friendId = friendId;
	}
	public SearchBean() {
		super();
		// TODO Auto-generated constructor stub
	}
}
