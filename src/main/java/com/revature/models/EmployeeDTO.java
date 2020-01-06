package com.revature.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

import com.revature.services.UserServices;

public class EmployeeDTO implements Serializable  {

	private static final long serialVersionUID = 7888951469121413987L;
	
	private int id;
	private String firstName;
	private String lastName;
	private String username;
	private String password;
	private ArrayList<Reinbursements> userReimbursements = UserServices.getReinbursementsForUser(id);


	public EmployeeDTO() {
		super();
	}

	public EmployeeDTO(int id, String firstName, String lastName, String username, String password, ArrayList<Reinbursements> userRe) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.userReimbursements = userRe;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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
		this.password = password;
	}
	
	public ArrayList<Reinbursements> getUserReimbursements() {
		return userReimbursements;
	}

	public void setUserReim(ArrayList<Reinbursements> userRe) {
		this.userReimbursements = userRe;
		}



	@Override
	public int hashCode() {
		return Objects.hash(firstName, id, lastName, password, username);
	}

	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof EmployeeDTO)) {
			return false;
		}
		EmployeeDTO other = (EmployeeDTO) obj;
		return Objects.equals(firstName, other.firstName) && id == other.id
				&& Objects.equals(lastName, other.lastName) && Objects.equals(password, other.password)
				&& Objects.equals(username, other.username);
	}

	@Override
	public String toString() {
		return "EmployeeDTO [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", username="
				+ username + ", password=" + password + "]";
	}
	
	
}
