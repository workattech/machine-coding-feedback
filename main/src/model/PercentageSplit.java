package model;


import Exceptions.InvalidSplitAddedException;

import java.util.ArrayList;
import java.util.Map;

public class PercentageSplit extends Split {

    public PercentageSplit(User paidBy, Map<User, Double> paidForUsers, ExpenseType expenseType, Double amount) {
        super(paidBy, paidForUsers, expenseType, amount);
    }

    @Override
    public boolean validate() {
        Double totalPercentage = 100.00;
        Double totalSpiltPercentage=0.00;
        for(Map.Entry<User,Double>entry : getPaidForUsers().entrySet()) {
            totalSpiltPercentage+=entry.getValue();
        }
        if(!totalPercentage.equals(totalSpiltPercentage)) throw new InvalidSplitAddedException("Total Split percentage does not add upto 100");
        return  true;
    }

    @Override
    public void calculateEachShare() {
        for(Map.Entry<User,Double> entry : getPaidForUsers().entrySet()) {
            Double percentageSplit = entry.getValue();
            Double amountToBePaid  = getAmount()*(percentageSplit/100.0);
            entry.setValue(amountToBePaid);
        }

    }
}
