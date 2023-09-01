package com.pankaj.splitwise.models;

public abstract class Split {
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Split(User user) {
		this.user = user;
	}
	private User user;
	private double amount;
	
	
}
