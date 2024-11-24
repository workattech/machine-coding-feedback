package org.main;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Random;

@Getter
@Setter
public class User {
    private String name;
    @Setter(AccessLevel.NONE)
    private String userId;
    private String phoneNum;
    private String emailId;
    private ArrayList<TransactionSummary> transactions;

    public User(String name, String phoneNum, String emailId) {
        this.name = name;
        this.phoneNum = phoneNum;
        this.emailId = emailId;
        this.userId = generateUserID();
        transactions = new ArrayList<>();
    }

    public String generateUserID() {
        return name+Integer.valueOf(phoneNum.trim());
    }

    private long getRandom() {
        Random r = new Random();
        return r.nextLong(100-000-000-00) + Integer.valueOf(phoneNum.trim());
    }

    public void printTransactions() {
        for (TransactionSummary transactionSummary : transactions) {
            transactionSummary.printTransactionSummary();
        }
    }
}
