package org.machinecoding;

import org.machinecoding.models.Expense;
import org.machinecoding.models.User;
import org.machinecoding.services.SplitWiseRunner;
import org.machinecoding.strategy.EqualSplittingStrategy;
import org.machinecoding.strategy.ExactSplittingStrategy;
import org.machinecoding.strategy.PercentageSplittingStrategy;
import org.machinecoding.strategy.SplittingStrategy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static org.machinecoding.Constants.*;

public class Main {
    public static void main(String[] args) {
        User user1 = new User("u1", "user1", "user1@gmail.com", "XXXXXXX");
        User user2 = new User("u2", "user2", "user2@gmail.com", "XXXXXXX");
        User user3 = new User("u3", "user3", "user3@gmail.com", "XXXXXXX");
        User user4 = new User("u4", "user4", "user3@gmail.com", "XXXXXXX");

        SplitWiseRunner runner = new SplitWiseRunner();
        runner.addUser(user1);
        runner.addUser(user2);
        runner.addUser(user3);
        runner.addUser(user4);

        Scanner scan = new Scanner(System.in);
        while (scan.hasNextLine()) {
            String command = scan.nextLine();
            processCommand(command, runner);
        }
        scan.close();
    }

    private static void processCommand(String command, SplitWiseRunner runner) {
        String[] parts = command.split(" ");
        String action = parts[0];

        switch (action) {
            case SHOW:
                handleShowCommand(runner, parts);
                break;
            case EXPENSE:
                handleExpenseCommand(runner, parts);
                break;
            default:
                break;
        }
    }

    private static void handleExpenseCommand(SplitWiseRunner runner, String[] parts) {
        String paidBy = parts[1];
        Double amount = Double.parseDouble(parts[2]);

        int len = Integer.parseInt(parts[3]);
        List<String> paidFor = new ArrayList<>(Arrays.asList(parts).subList(4, len + 4));

        String expenseType = parts[len + 4];
        Expense expense = runner.createExpense(amount, getSplittingStrategy(expenseType, len, parts));
        runner.addTransaction(paidBy, paidFor, expense);
    }

    private static SplittingStrategy getSplittingStrategy(String expenseType, int numUsers, String[] parts) {
        switch (expenseType){
            case EQUAL:
                return new EqualSplittingStrategy(numUsers);
            case EXACT:
                List<Double> splitAmt = new ArrayList<>();
                for(int i = 0; i < numUsers; i++) {
                    splitAmt.add(Double.parseDouble(parts[numUsers + 5 + i]));
                }
                return new ExactSplittingStrategy(splitAmt);
            case PERCENTAGE:
                List<Double> splitPercentage = new ArrayList<>();
                for(int i = 0; i < numUsers; i++) {
                    splitPercentage.add(Double.parseDouble(parts[numUsers + 5 + i]));
                }
                return new PercentageSplittingStrategy(splitPercentage);
            default:
                break;
        }

        return null;
    }

    private static void handleShowCommand(SplitWiseRunner runner, String[] parts) {
        if (parts.length == 1) {
            runner.getAllBalances();
        } else {
            runner.getUserBalance(parts[1]);
        }
    }
}