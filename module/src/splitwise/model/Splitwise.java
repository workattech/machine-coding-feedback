package splitwise.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Splitwise {
    List<User> users;
    double [][] Balances;

    public Splitwise(List<User> users) {
        this.users = users;
        this.Balances = new double[users.size()][users.size()];
        for (int i = 0; i < users.size(); i++) {
            for (int j = 0; j < users.size(); j++) {
                Balances[i][j] = 0;
            }
        }
    }

    boolean showBalances(User user1, boolean showOnlyNegative) {
        int pos = users.indexOf(user1);
        boolean nobalance = true;
        for (int i = 0; i < Balances[pos].length; i++) {
            if (Balances[pos][i] > 0) {
                nobalance = false;
                if (showOnlyNegative) continue;
                System.out.println(user1.getName() + " owes " + users.get(i).getName() + ": " + Balances[pos][i]);
            } else if(Balances[pos][i] < 0) {
                nobalance = false;
                System.out.println(users.get(i).getName() + " owes " + user1.getName() + ": " + Balances[i][pos]);
            }
        }
        return nobalance;
    }

    public void showBalances(User user1) {
        boolean nobalance = showBalances(user1, false);
        if(nobalance){
            System.out.println("No balances");
        }
    }

    public void showBalances() {
        boolean nobalance = true;
        for (int i = 0; i < users.size(); i++) {
            boolean val = showBalances(users.get(i), true);
            if(!val){
                nobalance = false;
            }
        }
        if(nobalance){
            System.out.println("No balances");
        }
    }

    void setBalances(User user1, User user2, double expense) {
        int pos1 = users.indexOf(user1);
        int pos2 = users.indexOf(user2);
        Balances[pos1][pos2] -=  expense;
        Balances[pos2][pos1] += expense;
        addPersonalExpense(user2, expense);
    }

    void addPersonalExpense(User user2, double expense) {
        user2.expenses += expense;
    }

    private double roundToTwoDecimals(double amount) {
        return Math.round(amount * 100.0) / 100.0;
    }

    public void addExpense(Expense expense) {
        User payer = expense.payer;
        Expense.ExpenseType type = expense.type;
        double totalExpense = expense.totalExpense;
        int size = expense.size;
        List<User> users = expense.users;
        List<Double> expenses = expense.expenses;
        switch (expense.type) {
            case EQUAL -> {
                double base = Math.floor((totalExpense / size) * 100) / 100.0;
                double remainder = totalExpense - (base * size);
                int extra = (int)Math.round(remainder * 100);
                for (int i = 0; i < size; i++) {
                    double amount = i < extra ? base + 0.01 : base;
                    setBalances(payer, users.get(i), roundToTwoDecimals(amount));
                }
            }
            case EXACT -> {
                for (int i = 0; i < size; i++) {
                    double amount = expenses.get(i);
                    setBalances(payer, users.get(i), roundToTwoDecimals(amount));
                }
            }
            case PERCENT -> {
                int sum = 0;
                for (int i = 0; i < size; i++) {
                    sum += expenses.get(i);
                }
                if (sum != 100) {
                    System.out.println("ERROR! Percentages don't add up to 100");
                } else {
                    for (int i = 0; i < size; i++) {
                        double amount = (expenses.get(i) * totalExpense) / 100;
                        setBalances(payer, users.get(i), roundToTwoDecimals(amount));
                    }
                }
            }
            default -> System.out.println("Invalid Expense");
        }
    }
}