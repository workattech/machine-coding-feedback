//package com.pankaj.splitwise.models;
//
//import java.util.List;
//import java.util.UUID;
//
//public abstract class Expense {
//	public String getExpenseId() {
//		return expenseId;
//	}
//	public void setExpenseId(String expenseId) {
//		this.expenseId = expenseId;
//	}
//	public double getAmount() {
//		return amount;
//	}
//	public void setAmount(double amount) {
//		this.amount = amount;
//	}
//	public User getPaidBy() {
//		return paidBy;
//	}
//	public void setPaidBy(User paidBy) {
//		this.paidBy = paidBy;
//	}
//	public List<Split> getSplits() {
//		return splits;
//	}
//	public void setSplits(List<Split> splits) {
//		this.splits = splits;
//	}
//	private String expenseId;
//	private double amount;
//	private User paidBy;
//	private List<Split> splits;
//	public Expense(double amount, User paidBy, List<Split> splits) {
//		this.expenseId = UUID.randomUUID().toString();;
//		this.amount = amount;
//		this.paidBy = paidBy;
//		this.splits = splits;
//	}
//	public abstract boolean validate();
//}