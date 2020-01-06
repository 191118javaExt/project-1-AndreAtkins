package com.revature.models;

import java.util.ArrayList;

import com.revature.services.UserServices;

public class Users {

 private String firstname;
 private String lastname;
 private String username;
 private String password;
 private String email;
 private int userId;
 private int roleId;
 private ArrayList<Reinbursements> userReimbursements = UserServices.getReinbursementsForUser(userId);
 

 
 public Users(String fname, String lname, String username, String password, String email, int roleId, int userId, ArrayList<Reinbursements> userRe ){ 
	
	this.firstname = fname;
	this.lastname = lname;
	this.username = username;
	this.password = password;
	this.email = email;
	this.roleId = roleId; 
	this.userId = userId;
	this.userReimbursements = userRe;
 }
 
 
 public String getFirstname() {
	return firstname;
}
public void setFirstname(String firstname) {
	this.firstname = firstname;
}


public String getLastname() {
	return lastname;
}
public void setLastname(String lastname) {
	this.lastname = lastname;
}


public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}


public String getPassword() {
	return password;
}
public void setPassword(String password) {
	int temp = password.hashCode();
	this.password =  new Integer(temp).toString();
}


public int getUserId() {
	return userId;
}
public void setUserId(int userId) {
	this.userId = userId;
}



public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}


public int getRoleId() {
	return roleId;
}
public void setRoleId(int roleId) {
	this.roleId = roleId;
}
 
public ArrayList<Reinbursements> getUserReimbursements() {
	return userReimbursements;
}

public void setUserReim(ArrayList<Reinbursements> userRe) {
	this.userReimbursements = userRe;
	}
 

	
}
