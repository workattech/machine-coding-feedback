package com.company;

import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class ExpenseService {
    enum Division {
        EQUAL,
        EXACT,
        PERCENT
    }

    private HashMap<String, HashMap<String, Double>> balances = new HashMap<>();
    private InputService inputService;

    public ExpenseService(InputService inputService) {
        balances = new HashMap<>();
        this.inputService = inputService;
        this.inputService.getUsers().forEach(user ->
                {
                    if (!balances.containsKey(user)) {
                        HashMap<String, Double> otherUsers = new HashMap<>();
                        this.inputService.getUsers().forEach(otherUser ->
                                {
                                    if (!otherUser.getName().equals(user.getName())) {
                                        otherUsers.put(otherUser.getName(), new Double("0"));
                                    }
                                }
                        );
                        balances.put(user.getName(), otherUsers);
                    }
                }
        );
    }

    public void manageExpense(String[] expenseInputArray) {
//        System.out.println("expense arr is " + Arrays.asList(expenseInputArray).toString());
        int noOfPeople = Integer.parseInt(expenseInputArray[3]);
        int count;

        Double amountPerHead = new Double("0");
        Double totalExpenditure = new Double(expenseInputArray[2]);
        if (expenseInputArray[noOfPeople + 4].equals(Division.PERCENT.toString())) {
            count = 0;
            while (count < noOfPeople) {
                if (!expenseInputArray[1].equals(expenseInputArray[count + 4])) {
                    amountPerHead = (totalExpenditure * new Double(expenseInputArray[noOfPeople + count + 5])) / new Double("100");
                    updateBalances(expenseInputArray, amountPerHead, count);
//                    Double prevBalance = balances.get(expenseInputArray[1]).get(expenseInputArray[count + 4]);
//                    balances.get(expenseInputArray[1]).replace(expenseInputArray[count + 4], prevBalance + amountPerHead);
                }
                count++;
            }

        } else if (expenseInputArray[noOfPeople + 4].equals(Division.EQUAL.toString())) {
            count = 0;
            while (count < noOfPeople) {
                if (!expenseInputArray[1].equals(expenseInputArray[count + 4])) {
                    amountPerHead = totalExpenditure / new Double(noOfPeople);
                    updateBalances(expenseInputArray, amountPerHead, count);
//                    Double prevBalance = balances.get(expenseInputArray[1]).get(expenseInputArray[count + 4]);
//                    balances.get(expenseInputArray[1]).replace(expenseInputArray[count + 4], prevBalance + amountPerHead);
                }
                count++;
            }

        } else if (expenseInputArray[noOfPeople + 4].equals(Division.EXACT.toString())) {
            count = 0;
            while (count < noOfPeople) {
                if (!expenseInputArray[1].equals(expenseInputArray[count + 4])) {
                    amountPerHead = new Double(expenseInputArray[noOfPeople + count + 5]);
                    updateBalances(expenseInputArray, amountPerHead, count);
//                    Double prevBalance = balances.get(expenseInputArray[1]).get(expenseInputArray[count + 4]);
//                    balances.get(expenseInputArray[1]).replace(expenseInputArray[count + 4], prevBalance + amountPerHead);
                }
                count++;
            }

        }
    }

    private void updateBalances(String[] inputArray, Double amountPerHead, int count) {
        Double prevBalance = balances.get(inputArray[1]).get(inputArray[count + 4]);
        balances.get(inputArray[1]).replace(inputArray[count + 4], prevBalance + amountPerHead);
        prevBalance = balances.get(inputArray[count + 4]).get(inputArray[1]);
        balances.get(inputArray[count + 4]).replace(inputArray[1], prevBalance - amountPerHead);
    }

    public void showBalance(String[] inputArray) {
//        System.out.println("show arr is " + Arrays.asList(inputArray).toString());
        AtomicBoolean noBalance = new AtomicBoolean(true);
        if (inputArray.length > 1) {

            balances.forEach((user, balances) ->
                    {
                        if (user.equals(inputArray[1])) {
                            balances.forEach((userOwing, balance) ->
                                    {
                                        if (balance > 0){
                                            System.out.println(userOwing + " owes " + user
                                                    + " : " + balance);
                                            noBalance.set(false);
                                        }
                                        else if(balance < 0){
                                            System.out.println(user + " owes " + userOwing
                                                    + " : " + balance * (-1));
                                            noBalance.set(false);
                                        }
                                    }
                            );
                        }
                    }
            );
//            System.out.println("\n\n" + balances);
        } else {
            System.out.println("showing all balances");
            balances.forEach((user, balances) ->
                    {
                        balances.forEach((userOwing, balance) ->
                                {
                                    if (balance > 0){
                                        System.out.println(userOwing + " owes " + user + " : " + balance);
                                        noBalance.set(false);
                                    }
//                                    else if(balance < 0)
//                                        System.out.println(user + " owes " + userOwing
//                                                + " : " + balance * (-1));
                                }
                        );
                    }
            );
//            System.out.println("\n\n" + balances);
        }
        if(noBalance.get() == true){
            System.out.println("No balances");
        }
    }
}
