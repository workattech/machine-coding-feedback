package src.splitwise;

import java.util.ArrayList;
import java.util.List;

public class ExactExpenseType implements ExpenseType {
    private double amountPaid;
    private List<Double> sharesOfUsers = new ArrayList<Double>();
    private User payer;
    private List<User> usersInvolvedInTransaction = new ArrayList<User>();

    public ExactExpenseType(String[] query) throws IllegalAccessException, IllegalArgumentException {
        if (query.length < 5) {
            throw new IllegalArgumentException("Insufficient data in query.");
        }
        int numberOfUsersInvolvedInTheTransaction = Integer.parseInt(query[3]);
        this.payer = appConfig.getUserFromId(query[1]);
        this.amountPaid = Double.parseDouble(query[2]);
        if (query.length != 5 + 2 * numberOfUsersInvolvedInTheTransaction) {
            throw new IllegalArgumentException("Number of users does not match the provided user list.");
        }
        for (int i = 4; i < 4 + numberOfUsersInvolvedInTheTransaction; ++i) {
            usersInvolvedInTransaction.add(appConfig.getUserFromId(query[i]));
        }
        for (int i = 5 + numberOfUsersInvolvedInTheTransaction; i < query.length; ++i) {
            sharesOfUsers.add(Double.parseDouble(query[i]));
        }
    }

    @Override
    public void validateExpense() throws IllegalArgumentException {
        if (usersInvolvedInTransaction.size() != sharesOfUsers.size())
            throw new IllegalArgumentException("Not enough split shares!");
        double totalValue = 0;
        for (int i = 0; i < sharesOfUsers.size(); ++i) {
            totalValue += sharesOfUsers.get(i);
        }
        if (totalValue != amountPaid)
            throw new IllegalArgumentException("Share total %s doesn't sum to actual total value!");
    }

    @Override
    public void addExpense() {
        for (int i = 0; i < usersInvolvedInTransaction.size(); ++i) {
            User loaner = usersInvolvedInTransaction.get(i);
            double amount = doubleHelper.getTwoDigitRoundedAmount(sharesOfUsers.get(i));
            payer.addTransaction(loaner.getUserId(), amount);
            loaner.addTransaction(payer.getUserId(), (-1.00f) * amount);
        }
    }

}
