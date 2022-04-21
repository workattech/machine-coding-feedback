import model.*;
import services.ExpenseManagerService;
import services.UserService;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        UserService userService = new UserService();
        ExpenseManagerService expenseManager = new ExpenseManagerService(userService);

        userService.addUser(new User("u1", new HashMap<User, Double>()));
        userService.addUser(new User("u2", new HashMap<User, Double>()));
        userService.addUser(new User("u3", new HashMap<User, Double>()));
        userService.addUser(new User("u4", new HashMap<User, Double>()));

        Scanner scanner = new Scanner(System.in);
        while (true) {
            String command = scanner.nextLine();
            String[] commands = command.split(" ");
            String commandType = commands[0];

            switch (commandType) {
                case "SHOW":
                    if (commands.length == 1) {
                        userService.showAllBalances();
                    } else {
                        userService.showBalanceForUser(commands[1]);
                    }
                    break;
                case "EXPENSE":
                    String paidBy = commands[1];
                    User paidByUser = userService.getUser(paidBy);
                    Double amount = Double.parseDouble(commands[2]);
                    int noOfUsers = Integer.parseInt(commands[3]);
                    String expenseType = commands[4 + noOfUsers];
                    Split split;
                    Expense expense;
                    Map<User, Double> splitListForUsers = new HashMap<User, Double>();
                    switch (expenseType) {
                        case "EQUAL":
                            for (int i = 0; i < noOfUsers; i++) {
                                String userName = commands[4 + i];
                                splitListForUsers.put(userService.getUser(userName), 0.0);
                            }
                            EqualSplit equalSplit = new EqualSplit(paidByUser, splitListForUsers, ExpenseType.EqualExpense, amount);
                            expense = new Expense(null, equalSplit, paidByUser);
                            expenseManager.addExpense(expense);
                            userService.showAllBalances();
                            break;
                        case "EXACT":
                            for (int i = 0; i < noOfUsers; i++) {
                                String userName = commands[4 + i];
                                Double splitAmount = Double.parseDouble(commands[5 + noOfUsers + i]);
                                splitListForUsers.put(userService.getUser(userName), splitAmount);
                            }
                            ExactSplit exactSplit = new ExactSplit(paidByUser, splitListForUsers, ExpenseType.ExactExpense, amount);
                            expense = new Expense(null, exactSplit, paidByUser);
                            expenseManager.addExpense(expense);
                            break;
                        case "PERCENT":
                            for (int i = 0; i < noOfUsers; i++) {
                                String userName = commands[4 + i];
                                Double splitPercentage = Double.parseDouble(commands[5 + noOfUsers + i]);
                                splitListForUsers.put(userService.getUser(userName), splitPercentage);
                            }
                            PercentageSplit percentageSplit = new PercentageSplit(paidByUser, splitListForUsers, ExpenseType.PercentExpense, amount);
                            expense = new Expense(null, percentageSplit, paidByUser);
                            expenseManager.addExpense(expense);
                            break;
                    }
                    break;
            }
        }
    }
}

