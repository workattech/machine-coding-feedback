package src.splitwise;

import java.util.List;

public class Splitwise {
    private AppConfig appConfig = AppConfig.getInstance();
    private ExpenseType expenseType;
    private Balances balances;

    public void createRandomUser(String userId, String name) {
        // ToDo: Create random string using a random generator but in Ideal application
        // we need user to put this.
        addUser(userId, name, "random", "random");
    }

    public void addExpense(String[] expenseInput) throws IllegalAccessException, IllegalArgumentException {
        String inputExpenseType = expenseInput[4 + Integer.parseInt(expenseInput[3])];
        if (inputExpenseType.equals(SupportedExpenseType.EQUAL.name())) {
            expenseType = new EqualExpenseType(expenseInput);
        } else if (inputExpenseType.equals(SupportedExpenseType.EXACT.name())) {
            expenseType = new ExactExpenseType(expenseInput);
        } else if (inputExpenseType.equals(SupportedExpenseType.PERCENT.name())) {
            expenseType = new PercentExpenseType(expenseInput);
        } else {
            throw new IllegalArgumentException("This expense type is not valid");
        }
        expenseType.validateExpense();
        expenseType.addExpense();
    }

    public List<String> showBalance(String[] showInput) throws IllegalAccessException {
        if (showInput.length == 1) {
            balances = new AllUserBalances();
        } else if (showInput.length == 2) {
            balances = new UserBalances(showInput[1]);
        } else {
            throw new IllegalArgumentException("SHOW only supports all or one user at a time!");
        }
        return balances.getBalances();
    }

    public void addUser(String userId, String name, String email, String mobileNumber) throws IllegalArgumentException {
        appConfig.addNewUser(new User(userId, name, email, mobileNumber));
    }
}
