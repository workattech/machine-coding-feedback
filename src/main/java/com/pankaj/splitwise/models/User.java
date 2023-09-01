package com.pankaj.splitwise.models;

public class User {
	public User(String name, String mail, String mobileNo) {
		this.name = name;
		this.mail = mail;
		this.mobileNo = mobileNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	
	private String name;
	private double amount;
	private String mail;
	private String mobileNo;
	
	
}
