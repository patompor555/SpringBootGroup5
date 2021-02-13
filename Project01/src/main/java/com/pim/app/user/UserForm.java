package com.pim.app.user;

public class UserForm {
	
	private int userID;
	
	private String fname;
	
	private String lname;
	
	private String userEmail;
	
	private String password;
	
	public UserForm() {}
	
	public UserForm(int UserID,String Fname, String Lname, String Email, String Password) {
        this.userID = UserID;
        this.fname = Fname;
        this.lname = Lname;
        this.userEmail = Email;
        this.password = Password;
    }
	

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
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


	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
