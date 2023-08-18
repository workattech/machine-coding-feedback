package org.example.entities;

import java.util.HashMap;
import java.util.Map;

public class UserBalanceSheet {
    private final User user;
    private HashMap<String, Double> balance;

    public UserBalanceSheet(User user, User[] allUsers) {
        this.user = user;
        balance = new HashMap<>();
        for (User u : allUsers) {
            if (!u.equals(user))
                balance.put(u.getName(), 0.0);
        }
    }


    public void updateB(String payer, Double share) {
        balance.put(payer, balance.get(payer) + share);
    }

    public Double getAmountForOthers(String otherUser) {
        return balance.get(otherUser);
    }

    public void printBalance() {
        for (Map.Entry<String, Double> entry : balance.entrySet()) {
            //format User4 owes User1: 250
            if (entry.getValue() > 0.0) {
                System.out.println(this.user.getName() + " owes " + entry.getKey() + ": " + entry.getValue());
            }
        }
    }

    public void printBalance(String user) {
        if (this.user.getName().equals(user)) {
            for (Map.Entry<String, Double> entry : balance.entrySet()) {
                //format User4 owes User1: 250
                if (entry.getValue() > 0.0) {
                    System.out.println(this.user.getName() + " owes " + entry.getKey() + ": " + entry.getValue());
                }
            }
        } else {

            for (Map.Entry<String, Double> entry : balance.entrySet()) {
                //format User4 owes User1: 250
                if (entry.getKey().equals(user) && entry.getValue() > 0.0) {
                    System.out.println(this.user.getName()+ " owes " + user + ": " + entry.getValue());
                }
            }
        }
    }

}
