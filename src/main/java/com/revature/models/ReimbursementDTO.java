package com.revature.models;

public class ReimbursementDTO {

	
    private double amount;

	private String descr;

	private int typeId;
	
	private int author;
	
	private int reimid;
	
	
	 public ReimbursementDTO() {
	        super();
	    }
	 
	
	public ReimbursementDTO (double amount, String descr, int typeId, int reimid) {
		
		this.amount = amount;
		this.descr = descr;
		this.typeId =typeId;
		this.reimid = reimid;
	
	}

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	public int getAuthor() {
		return author;
	}

	public void setAuthor(int author) {
		this.author = author;
	}


	public int getReimid() {
		return reimid;
	}


	public void setReimid(int reimid) {
		this.reimid = reimid;
	}	
}
