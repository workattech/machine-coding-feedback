package org.main;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class Transaction {
    private String transactionUser;
    private Float totalTransactionValue;
    private StringFloatMap transactionMap;
    private TransactionType transactionType;
    private static final float EPSILON = 0.000001f;

    public boolean processTransaction(ArrayList<String> transactionDetails, Group group) {
        transactionType = getTransType(transactionDetails);

        if (validateTransactionDetails(transactionDetails, group)) {
            group.getBalances().updateBalances(transactionUser, transactionMap, totalTransactionValue, group);
            return true;
        }
        return false;
    }

    private boolean validateTransactionDetails(ArrayList<String> transactionDetails, Group group) {
        if (!basicChecksPassed(transactionDetails, group)) {
            return false;
        }
        if (transactionType != null) {
            return transactionType.validateTransactionDetails(transactionDetails, this);
        }
        return false;
    }

    private boolean basicChecksPassed(ArrayList<String> transactionDetails, Group group) {
        transactionMap = new StringFloatMap();
        transactionUser = transactionDetails.get(0);
        if (!group.getGroupUsers().checkIfUserIsPartOfGroup(transactionUser)) {
            return false;
        }
        totalTransactionValue = Float.parseFloat(transactionDetails.get(1));
        if (totalTransactionValue < EPSILON) {
            return false;
        }
        int numOfUsers = Integer.parseInt(transactionDetails.get(2));
        if (numOfUsers < 0) {
            return false;
        }
        return true;
    }

    public boolean checkFloatsAreEqual(Float num1, Float num2) {
        return Math.abs(num1 - num2) < EPSILON;
    }

    public TransactionType getTransType(ArrayList<String> transactionDetails) {
        TransactionType transactionType = null;
        for (String input : transactionDetails) {
            if (input.equals("EQUAL")) {
                transactionDetails.remove("EQUAL");
                transactionType = TransactionType.fromString("EQUAL");
                break;
            }
            if (input.equals("EXACT")) {
                transactionDetails.remove("EXACT");
                transactionType = TransactionType.fromString("EXACT");
                break;
            }
            if (input.equals("PERCENT")) {
                transactionDetails.remove("PERCENT");
                transactionType = TransactionType.fromString("PERCENT");
                break;
            }
        }
        return transactionType;
    }
}
