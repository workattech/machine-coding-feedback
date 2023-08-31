package com.pankaj.splitwise.models;


// SAY THERE ARE 4 FRIENDS U1, U2, U3, U4. 
// AND U1 PAY 1000 ASSUME ITS A EQUAL SPLIT(250 EACH)
// SO HERE SPLIT IS HAVING USER AND AMOUNT FOR WHICH U1 HAS PAID.
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
