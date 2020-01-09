package com.revature.models;

public class StatusDTO {

	private int id;
	private int status;
	
	
	
	
	public StatusDTO() {
		super();
	}
	
	
	public StatusDTO(int id, int status) {
		this.id = id;
		this.status = status;
	}
	
	
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "StatusDTO [ID=" + id + ", statusNum=" + status + "]";
	}
	
	
	
	
	
	
	
	
}
