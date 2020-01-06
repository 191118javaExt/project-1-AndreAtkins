package com.revature.models;

public class Reinbursements {

	private int reinbursementId;
	private double amount;
	private String timeSub;
	private String timeRes;
	private String desc;
	private int author;
	private int resolver;
	private int statusId;
	private int typeId;
    private byte[] receipt;
	
	
	public Reinbursements(int reinId, double amount, String timesub, String timeres, 
	String desc, int auth, int resolver, int statusId, int typeId, byte[] reciept) {
	
	this.reinbursementId = reinId;
	this.amount = amount;
	this.timeSub = timesub;
	this.timeRes = timeres;
	this.desc = desc;
	this.author = auth;
	this.resolver = resolver;
	this.statusId= statusId;
	this.typeId = typeId;
    this.receipt = reciept;
	
	}


	public double getAmount() {
		return amount;
	}


	public void setAmount(int amount) {
		this.amount = amount;
	}


	public int getResolver() {
		return resolver;
	}


	public void setResolver(int resolver) {
		this.resolver = resolver;
	}


	public String getTimeRes() {
		return timeRes;
	}


	public void setTimeRes(String timeRes) {
		this.timeRes = timeRes;
	}


	public String getTimeSub() {
		return timeSub;
	}


	public void setTimeSub(String timeSub) {
		this.timeSub = timeSub;
	}


	public String getDesc() {
		return desc;
	}


	public void setDesc(String desc) {
		this.desc = desc;
	}


	public byte[] getReceipt() {
		return receipt;
	}


	public void setReceipt(byte[] receipt) {
		this.receipt = receipt;
	}


	public int getAuthor() {
		return author;
	}


	public void setAuthor(int author) {
		this.author = author;
	}


	public int getStatusId() {
		return statusId;
	}


	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}


	public int getTypeId() {
		return typeId;
	}


	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}


	public int getReinbursementId() {
		return reinbursementId;
	}


	public void setReinbursementId(int reinbursementId) {
		this.reinbursementId = reinbursementId;
	}
}
