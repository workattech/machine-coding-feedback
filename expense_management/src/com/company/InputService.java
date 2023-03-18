package com.company;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class InputService {
    enum Operation {
        EXPENSE,
        SHOW
    }

    private static InputService inputService;
    private ArrayList<User> users;

    private InputService() {
        users = new ArrayList<>();
        users.add(new User("user1", "email1", "no1"));
        users.add(new User("user2", "email2", "no2"));
        users.add(new User("user3", "email3", "no3"));
        users.add(new User("user4", "email4", "no4"));
    }

    public static synchronized InputService getInstance() {
        if (inputService == null) {
            inputService = new InputService();
        }
        return inputService;
    }

    public ArrayList<User> getUsers() {
        return this.users;
    }

    public void takeInputs() throws IOException {
        String path = "src/com/company/input.txt";
        ExpenseService expenseService = new ExpenseService(inputService);
        String line = null;
        try (BufferedReader reader = new BufferedReader(new FileReader(path));) {
            while ((line = reader.readLine()) != null) {
                String[] arr = line.split(" ");
                if (arr[0].equals(Operation.EXPENSE.toString())) {
                    expenseService.manageExpense(arr);
                } else if (arr[0].equals(Operation.SHOW.toString())) {
                    expenseService.showBalance(arr);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
