package com.mingleup.models;

public class UploadBean {
	String comment;
	String image;
	int user_id;
	String dateTime;
	String username;
	String dp;
	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	
	public UploadBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UploadBean(String comment, String image, int user_id,
			String dateTime, String username, String dp) {
		super();
		this.comment = comment;
		this.image = image;
		this.user_id = user_id;
		this.dateTime = dateTime;
		this.username = username;
		this.dp = dp;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getDp() {
		return dp;
	}

	public void setDp(String dp) {
		this.dp = dp;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	

	
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	

}
