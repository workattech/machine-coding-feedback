package model;

import Exceptions.InvalidSplitAddedException;

import java.util.ArrayList;
import java.util.Map;

public abstract class Split {
    private User paidBy;
    private Map<User,Double> paidForUsers;
    private ExpenseType expenseType;
    private Double amount;


    public abstract boolean validate() throws InvalidSplitAddedException;

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public abstract void calculateEachShare();

    public Split(User paidBy, Map<User, Double> paidForUsers, ExpenseType expenseType, Double amount) {
        this.paidBy = paidBy;
        this.paidForUsers = paidForUsers;
        this.expenseType = expenseType;
        this.amount = amount;
    }

    public User getPaidBy() {
        return paidBy;
    }

    public void setPaidBy(User paidBy) {
        this.paidBy = paidBy;
    }

    public Map<User,Double> getPaidForUsers() {
        return paidForUsers;
    }

    public void setPaidForUsers(Map<User,Double> paidForUsers) {
        this.paidForUsers = paidForUsers;
    }

    public ExpenseType getExpenseType() {
        return expenseType;
    }

    public void setExpenseType(ExpenseType expenseType) {
        this.expenseType = expenseType;
    }
}
