package model;

import Exceptions.InvalidSplitAddedException;

import java.util.ArrayList;
import java.util.Map;

public class ExactSplit extends Split {


    public ExactSplit(User paidBy, Map<User, Double> paidForUsers, ExpenseType expenseType, Double amount) {
        super(paidBy, paidForUsers, expenseType, amount);
    }

    @Override
    public boolean validate() throws InvalidSplitAddedException {
        Double totalAmount=getAmount();
        Double totalSplitAmount=0.0;
        for(Map.Entry<User,Double> entry: getPaidForUsers().entrySet()) {
            totalSplitAmount+=entry.getValue();
        }
        if(!totalAmount.equals(totalSplitAmount)) throw new InvalidSplitAddedException("Total Split amount does not add upto totak amount");
        return  true;
    }

    @Override
    public void calculateEachShare() {
    }
}
