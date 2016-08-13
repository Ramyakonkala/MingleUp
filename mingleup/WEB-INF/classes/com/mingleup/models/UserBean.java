package com.mingleup.models;

public class UserBean {

	private String user;
    private String password;
   String email;
   String DOB;
   String gender;
    public String getUser() {
        return user;
    }
    public void setUser(String user) {
        this.user = user;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public UserBean() {
        // TODO Auto-generated constructor stub
    }
	public UserBean(String user, String password, String email, String dOB,
			String gender) {
		super();
		this.user = user;
		this.password = password;
		this.email = email;
		DOB = dOB;
		this.gender = gender;
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
