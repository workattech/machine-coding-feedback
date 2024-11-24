package org.main;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.*;
import java.text.DecimalFormat;
import java.util.concurrent.atomic.AtomicInteger;

@Getter
@Setter
class StringFloat {
    private String userId;
    private Float amt;

    public StringFloat(String userId, Float amt) {
        this.userId = userId;
        this.amt = amt;
    }


}

class StringFloatMap extends HashMap<String, Float> {
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        this.forEach((key, value) -> sb.append(key).append("=").append(value).append(", "));
        if (sb.length() > 1) sb.setLength(sb.length() - 2); // Remove trailing comma and space
        sb.append("}");
        return sb.toString();
    }
}

@ToString
public class Balances {
    private Currencies currencies;
    private Float totalGroupSpending;
    private HashMap<String, StringFloatMap> usersBalancesMap;
    private HashMap<String, StringFloatMap> userBalancesSimplifiedMap;
    public static final DecimalFormat df = new DecimalFormat("#.00");

    public Balances(Currencies currencies) {
        this.currencies = currencies;
        this.totalGroupSpending = 0f;
        usersBalancesMap = new HashMap<>();
        userBalancesSimplifiedMap = new HashMap<>();
    }

    //Function to debug print of Map
    public void printBalancesMap() {
        System.out.println("\n -- User balances map -- \n");
        for (Map.Entry<String, StringFloatMap> usersBalances : usersBalancesMap.entrySet()) {
            System.out.println("{ "+ usersBalances.getKey()+" = { "+ usersBalances.getValue()+ " }" +" }");
        }
    }

    public void initlizeUsersBalancesMap(GroupUsers users) {
        initlizeUsersBalancesMap(users, this.usersBalancesMap);
    }

    public void initlizeUsersBalancesMap(GroupUsers users, HashMap<String, StringFloatMap> usersBalancesMapInit) {
        ArrayList<String> userIds = new ArrayList<>();
        StringFloatMap tempMap = new StringFloatMap();

        //creating the Map for all Users present in the Group
        for (Map.Entry<String, User> user : users.getUsers().entrySet()) {
            usersBalancesMapInit.put(user.getKey(), new StringFloatMap());
            userIds.add(user.getKey());
        }

        //Updating every UserId with mappings of other user with default value as 0f
        for (Map.Entry<String, StringFloatMap> user : usersBalancesMapInit.entrySet()) {
            for (String userId : userIds) {
                //Avoiding BalanceMap of its own in the balances Map
                if (user.getKey() != userId) {
                    user.getValue().put(userId, 0f);
                }
            }
        }
    }

    public HashMap<String, Float> getBalanceForUser(String userId)  {
        return usersBalancesMap.get(userId);
    }

    public Float getBalanceForUser (String userId1, String userId2, HashMap<String, StringFloatMap> usersBalancesMaping) {
        StringFloatMap userBalances = usersBalancesMaping.get(userId1);
        return userBalances.get(userId2);
    }

    //Set of print functions for Single user input
    public void getBalanceForUserPrint(String userId1) {
        getBalanceForUserPrint(userId1, true);
    }

    public void getBalanceForUserPrint(String userId1, Boolean showNoBalance) {
        getBalanceForUserPrint(userId1, true, usersBalancesMap);
    }

    public int getBalanceForUserPrint(String userId1, Boolean showNoBalance, HashMap<String, StringFloatMap> usersBalancesMaping)
    {
        AtomicInteger userWithBalanceSum = new AtomicInteger(0);

        getBalanceForUser(userId1).forEach((userIdBal, balanceMap) -> {
            userWithBalanceSum.addAndGet(getBalanceForUserPrint(userId1, userIdBal, false, usersBalancesMaping));
        });

        if (userWithBalanceSum.get() == 0 && showNoBalance) {
            System.out.println("No Balance");
        }

        return userWithBalanceSum.get();
    }

    //Set of print functions for Dual user input
    // By default, it shows the No Balance Msg
    public void getBalanceForUserPrint(String userId1, String userId2) {
        getBalanceForUserPrint(userId1, userId2, true);
    }

    public void getBalanceForUserPrint(String userId1, String userId2, Boolean showNoBalance) {
        getBalanceForUserPrint(userId1, userId2, showNoBalance, usersBalancesMap);
    }

    public int getBalanceForUserPrint(String userId1, String userId2, Boolean showNoBalance, HashMap<String, StringFloatMap> usersBalancesMaping) {
        Float balance = getBalanceForUser(userId1, userId2, usersBalancesMaping);

        if (balance > 0) {
            System.out.println(userId2+ " Owes " + userId1 + " an amount of "+ currencies.getCurrencySymbol()+df.format(balance));
            return 1;
        } else if (showNoBalance) {
            System.out.println("No Balance");
        }
        return 0;
    }

    public void printGroupBalances() {
        System.out.println("\n -- Group balances Summary -- ");
        AtomicInteger userWithBalanceSum = new AtomicInteger(0);

        usersBalancesMap.forEach( (userId, userBalancesMap) -> {
            userWithBalanceSum.addAndGet(getBalanceForUserPrint(userId, false, usersBalancesMap));
        } );

        if (userWithBalanceSum.get() == 0) {
            System.out.println("No Balance");
        }
    }

    public void printSimpliedBalances() {
        System.out.println("\n -- Simplified balances Summary -- ");

        AtomicInteger userWithBalanceSum = new AtomicInteger(0);

        userBalancesSimplifiedMap.forEach( (userId, userBalancesMap) -> {
            userWithBalanceSum.addAndGet(getBalanceForUserPrint(userId, false, userBalancesSimplifiedMap));
        } );

        if (userWithBalanceSum.get() == 0) {
            System.out.println("No Balance");
        }
    }

    public void processSimplifiedBalances(GroupUsers users) {
        Comparator<StringFloat> byBalance = (p1, p2) -> Float.compare(p2.getAmt(), p1.getAmt());
        PriorityQueue<StringFloat> owedSet = new PriorityQueue<>(byBalance);
        PriorityQueue<StringFloat> owesSet = new PriorityQueue<>(byBalance);
        initlizeUsersBalancesMap(users, this.userBalancesSimplifiedMap);
        updateOwesAndOwedSet(owedSet, owesSet);
        calculateAndUpdateSimplifiedBalances(owedSet, owesSet);

    }

    private void calculateAndUpdateSimplifiedBalances(PriorityQueue<StringFloat> owedSet, PriorityQueue<StringFloat> owesSet)
    {
        while (!(owedSet.isEmpty() || owesSet.isEmpty())) {
            StringFloat temp1 = owedSet.poll();
            StringFloat temp2 = owesSet.poll();

            /*Diff is negative which means that owedSet user will be cleared of balance and gets deleted and diff amt will be left in owes Set
            Diff is Positive which means that owesSet user will be cleared of balance and gets deleted and diff amt will be left in owed set*/

            Float balanceAmt = temp1.getAmt() - temp2.getAmt();
            Float paymentAmt = balanceAmt<0? temp1.getAmt():temp2.getAmt();

            if (balanceAmt < 0) {
                owesSet.add(new StringFloat(temp2.getUserId(), Math.abs(balanceAmt)));
            } else if (balanceAmt > 0) {
                owedSet.add(new StringFloat(temp1.getUserId(), balanceAmt));
            }
            userBalancesSimplifiedMap.get(temp1.getUserId()).put(temp2.getUserId(), paymentAmt);
        }
    }

    private void updateOwesAndOwedSet(PriorityQueue<StringFloat> owedSet, PriorityQueue<StringFloat> owesSet) {
        usersBalancesMap.forEach( (userId, userBalances) -> {
            float[] totalBalance = {0f};
            userBalances.forEach( (_, balance) -> {
                totalBalance[0] = totalBalance[0] + balance;
            });
            if (totalBalance[0] < 0f) {
                owesSet.add(new StringFloat(userId, Math.abs(totalBalance[0])));
            } else {
                owedSet.add(new StringFloat(userId, totalBalance[0]));
            }
        });
    }

    public void updateBalances(String transactionUserId, StringFloatMap transactionDetails, Float totalTransactionVal, Group group)
    {
        totalGroupSpending = totalGroupSpending + totalTransactionVal;
        updateTransactionUserBalances(transactionUserId, transactionDetails, totalTransactionVal, group);
    }

    public void updateTransactionUserBalances(String transactionUserId, StringFloatMap transactionDetails, Float totalTransactionVal, Group group) {
        StringFloatMap transactionUserBalances = usersBalancesMap.get(transactionUserId);
        for(Map.Entry<String, Float> transaction : transactionDetails.entrySet()) {
            addTransactionSummaryToUser(transactionUserId, transaction.getKey(), transaction.getValue(), totalTransactionVal, group);
            if ( !(transactionUserId.equals(transaction.getKey())) ) {
                updateTransactionSplitUserBalances(transactionUserId, transaction.getKey(), transaction.getValue());
                Float updatedBalance = transaction.getValue() + transactionUserBalances.get(transaction.getKey());
                transactionUserBalances.put(transaction.getKey(), updatedBalance);
            }
        }
    }

    public void updateTransactionSplitUserBalances(String  transactionUserId, String splitUser, Float transAmt) {
        StringFloatMap splitUserBalances = usersBalancesMap.get(splitUser);
        splitUserBalances.put(transactionUserId, splitUserBalances.get(transactionUserId) - transAmt);
    }

    public void addTransactionSummaryToUser(String transactorUser, String transactionUser, Float transactionUserShare, Float totalTransactionVal, Group group) {
        TransactionSummary transactionSummary = new TransactionSummary(transactorUser, totalTransactionVal, transactionUserShare);
        group.getGroupUsers().getUserByUserId(transactionUser).getTransactions().add(transactionSummary);
    }
}
