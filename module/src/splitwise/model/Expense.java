package splitwise.model;

import java.util.List;

public class Expense {

    public enum ExpenseType {
        EQUAL, EXACT, PERCENT
    }

    User payer;
    double totalExpense;
    int size;
    ExpenseType type;
    List<User> users;
    List<Double> expenses;

    public Expense(User payer, double totalExpense, ExpenseType type, List<User> users, List<Double> expenses) {
        this.payer = payer;
        this.totalExpense = totalExpense;
        this.type = type;
        this.users = users;
        this.size = users.size();
        this.expenses = expenses;
    }

    public Expense(User payer, double totalExpense, ExpenseType type, List<User> users) {
        this(payer, totalExpense, type, users, null);
    }
}
