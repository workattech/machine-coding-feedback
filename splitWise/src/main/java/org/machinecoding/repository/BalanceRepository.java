package org.machinecoding.repository;

import org.machinecoding.models.User;
import org.machinecoding.models.UserPair;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class BalanceRepository {
    private Map<UserPair, Double> userBalanceMap;
    // a b (a -> b) => a owes b

    public BalanceRepository() {
        this.userBalanceMap = new HashMap<>();
    }

    public void addUserBalance(UserPair pair, Double balance) {
        balance = roundToTwoDecimalPlaces(balance);

        if (Objects.equals(pair.getFriend(), pair.getUser())) return;
        if (userBalanceMap.containsKey(pair)) {
            userBalanceMap.put(pair, userBalanceMap.get(pair) + balance);
        } else {
            userBalanceMap.put(pair, balance);
        }

        // simplify transactions
        UserPair pair2 = new UserPair(pair.getFriend(), pair.getUser());
        if (userBalanceMap.containsKey(pair2)) {
            Double amt1 = userBalanceMap.get(pair);
            Double amt2 = userBalanceMap.get(pair2);

            if (amt1 > amt2) {
                userBalanceMap.put(pair, amt1 - amt2);
                userBalanceMap.remove(pair2);
            } else if (amt1 < amt2) {
                userBalanceMap.put(pair2, amt2 - amt1);
                userBalanceMap.remove(pair);
            } else {
                userBalanceMap.remove(pair);
                userBalanceMap.remove(pair2);
            }
        }
    }

    private Double roundToTwoDecimalPlaces(Double value) {
        return Math.round(value * 100.0) / 100.0;
    }

    public void getUserBalance(User user) {
        boolean gotTransaction = false;
        for (Map.Entry<UserPair, Double> entry : userBalanceMap.entrySet()) {
            User usr = entry.getKey().getUser();
            User frnd = entry.getKey().getFriend();
            if (Objects.equals(usr, user) || Objects.equals(frnd, user)) {
                System.out.println(usr.getName() + " owes " + frnd.getName() + ": " + entry.getValue());
                gotTransaction = true;
            }
        }

        if (!gotTransaction) {
            System.out.println("No balances");
        }
    }

    public void getAllBalances() {
        boolean gotTransaction = false;
        for (Map.Entry<UserPair, Double> entry : userBalanceMap.entrySet()) {
            User usr = entry.getKey().getUser();
            User frnd = entry.getKey().getFriend();
            System.out.println(usr.getName() + " owes " + frnd.getName() + ": " + entry.getValue());
            gotTransaction = true;
        }

        if (!gotTransaction) {
            System.out.println("No balances");
        }
    }
}
