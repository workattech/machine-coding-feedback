package org.example.entities;

import java.util.HashMap;
import java.util.Map;

public class UserBase {

    private HashMap<String, UserBalanceSheet> userAndBalance;

    public UserBase(User[] user) {
        userAndBalance = new HashMap<>();
        for (User u : user) {
            UserBalanceSheet userBalanceSheet = new UserBalanceSheet(u, user);
            userAndBalance.put(u.getName(), userBalanceSheet);
        }
    }

    public void updateBalanceSheet(String payer, String otherUser, Double share) {
        UserBalanceSheet payerB = userAndBalance.get(payer);
        UserBalanceSheet otherUserB = userAndBalance.get(otherUser);
        Double payerOwesOther = payerB.getAmountForOthers(otherUser);
        if (payerOwesOther > share) {
            payerB.updateB(otherUser, -share);
        } else if (payerOwesOther > 0.0) {
            payerB.updateB(otherUser, -payerOwesOther);
            otherUserB.updateB(payer, share - payerOwesOther);
        } else {
            otherUserB.updateB(payer, share);
        }
    }

    public void printBalance() {


        for (Map.Entry<String, UserBalanceSheet> entry : userAndBalance.entrySet()) {
            entry.getValue().printBalance();
        }
    }

    public void printBalance(String user) {
        for (Map.Entry<String, UserBalanceSheet> entry : userAndBalance.entrySet()) {
            entry.getValue().printBalance(user);
        }
    }
}
