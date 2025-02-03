package org.machinecoding.models;

import org.machinecoding.strategy.SplittingStrategy;

public class Expense {
    private Double amount;
    private SplittingStrategy strategy;

    public Expense(Double amount, SplittingStrategy strategy) {
        this.amount = amount;
        this.strategy = strategy;
    }

    public SplittingStrategy getStrategy() {
        return strategy;
    }

    public Double getAmount() {
        return amount;
    }
}
