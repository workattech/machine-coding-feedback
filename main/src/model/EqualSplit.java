package model;

import java.util.ArrayList;
import java.util.Map;

public class EqualSplit extends Split {


    public EqualSplit(User paidBy, Map<User, Double> paidForUsers, ExpenseType expenseType, Double amount) {
        super(paidBy, paidForUsers, expenseType, amount);
    }

    @Override
    public boolean validate() {
        return true;
    }

    @Override
    public void calculateEachShare() {
        int noOfUsers  = getPaidForUsers().size();
        Double equalSplit = getAmount()/noOfUsers;
        for (Map.Entry<User,Double> entry : getPaidForUsers().entrySet()) {
            entry.setValue(equalSplit);
        }
    }
}
