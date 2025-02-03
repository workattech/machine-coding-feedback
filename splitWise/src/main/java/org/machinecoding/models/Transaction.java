package org.machinecoding.models;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Transaction {
    private User paidBy;
    private List<User> paidFor;
    private Expense expense;

    private Map<User, Double> splits; // <userId, amount

    public Transaction(User paidBy, List<User> paidFor, Expense expense) {
        this.paidBy = paidBy;
        this.paidFor = paidFor;
        this.expense = expense;
        this.splits = new HashMap<>();
    }

    public void populateSplitMap() {
        List<Double> splitAmount = expense.getStrategy().getSplit(expense.getAmount());
        for (int i = 0; i < paidFor.size(); i++) {
            splits.put(paidFor.get(i), splitAmount.get(i));
        }
    }

    public Map<User, Double> getSplits() {
        return splits;
    }

    public User getPaidBy() {
        return paidBy;
    }

    public List<User> getPaidFor() {
        return paidFor;
    }

    public Expense getExpense() {
        return expense;
    }
}
