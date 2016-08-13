package com.mingleup.models;

public class SuggestedBean {
int friendId;
String name;
String email;
String DOB;
String gender;
String dp;

public SuggestedBean() {
	super();
	// TODO Auto-generated constructor stub
}
public SuggestedBean(int friendId, String name, String email, String dOB,
		String gender, String dp) {
	super();
	this.friendId = friendId;
	this.name = name;
	this.email = email;
	DOB = dOB;
	this.gender = gender;
	this.dp = dp;
}
public String getDp() {
	return dp;
}
public void setDp(String dp) {
	this.dp = dp;
}
public int getFriendId() {
	return friendId;
}
public void setFriendId(int friendId) {
	this.friendId = friendId;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getDOB() {
	return DOB;
}
public void setDOB(String dOB) {
	DOB = dOB;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
}
