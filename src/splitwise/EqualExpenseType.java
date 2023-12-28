package src.splitwise;

import java.util.ArrayList;
import java.util.List;

public class EqualExpenseType implements ExpenseType {
    private double amountPaid;
    private User payer;
    private List<User> usersInvolvedInTransaction = new ArrayList<User>();

    public EqualExpenseType(String[] query) throws IllegalAccessException {
        if (query.length < 5) {
            throw new IllegalArgumentException("Insufficient data in query.");
        }
        int numberOfUsersInvolvedInTheTransaction = Integer.parseInt(query[3]);
        this.payer = appConfig.getUserFromId(query[1]);
        this.amountPaid = Double.parseDouble(query[2]);
        if (query.length != 5 + numberOfUsersInvolvedInTheTransaction) {
            throw new IllegalArgumentException("Number of users does not match the provided user list.");
        }
        for (int i = 4; i < 4 + numberOfUsersInvolvedInTheTransaction; ++i) {
            usersInvolvedInTransaction.add(appConfig.getUserFromId(query[i]));
        }
    }

    /**
     * We can validate duplicate users, non-existent users, or negative amounts
     */
    @Override
    public void validateExpense() throws IllegalArgumentException {
    }

    @Override
    public void addExpense() {
        for (int i = 0; i < usersInvolvedInTransaction.size(); ++i) {
            User loaner = usersInvolvedInTransaction.get(i);
            double amount = doubleHelper
                    .getTwoDigitRoundedAmount(amountPaid / (double) usersInvolvedInTransaction.size());
            payer.addTransaction(loaner.getUserId(), amount);
            loaner.addTransaction(payer.getUserId(), (-1.00f) * amount);
        }
    }
}
