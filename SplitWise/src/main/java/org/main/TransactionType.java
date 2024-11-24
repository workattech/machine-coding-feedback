package org.main;

import lombok.Getter;

import java.util.ArrayList;

@Getter
public enum TransactionType {
    EXACT("EXACT") {
        @Override
        public boolean validateTransactionDetails(ArrayList<String> transDetails, Transaction transaction) {
            int numOfUsers = Integer.parseInt(transDetails.get(2));
            for (int i = 1; i <= numOfUsers; i++) {
                Float transVal = Float.parseFloat(transDetails.get(2 + i + numOfUsers));
                transaction.getTransactionMap().put(transDetails.get(2 + i), transVal);
            }
            return checkIfTransactionsMatchesTotal(transaction);
        }
    },
    EQUAL("EQUAL") {
        @Override
        public boolean validateTransactionDetails(ArrayList<String> transDetails, Transaction transaction) {
            int numOfUsers = Integer.parseInt(transDetails.get(2));
            for (int i = 1; i <= numOfUsers; i++) {
                transaction.getTransactionMap().put(transDetails.get(2+i), transaction.getTotalTransactionValue() / numOfUsers);
            }
            return true;
        }
    },
    PERCENT("PERCENT") {
        @Override
        public boolean validateTransactionDetails(ArrayList<String> transDetails, Transaction transaction) {
            float totalTransPerc = 0f;
            int numOfUsers = Integer.parseInt(transDetails.get(2));
            for (int i = 1; i <= numOfUsers; i++) {
                Float transPer = Float.parseFloat(transDetails.get(2+i+numOfUsers));
                totalTransPerc += transPer;
                transaction.getTransactionMap().put(transDetails.get(2+i), transaction.getTotalTransactionValue() * (transPer / 100));
            }
            return transaction.checkFloatsAreEqual(totalTransPerc, 100f);
        }
    };

    private final String transactionName;

    TransactionType(String transactionName) {
        this.transactionName = transactionName;
    }

    public abstract boolean validateTransactionDetails(ArrayList<String> trans, Transaction transaction);

    protected boolean checkIfTransactionsMatchesTotal(Transaction transaction) {
        float sum = transaction.getTransactionMap().values().stream().reduce(0f, Float::sum);
        return transaction.checkFloatsAreEqual(sum, transaction.getTotalTransactionValue());
    }

    public static TransactionType fromString(String name) {
        for (TransactionType transactionType : TransactionType.values()) {
            if (transactionType.transactionName.equalsIgnoreCase(name)) {
                return transactionType;
            }
        }
        throw new IllegalArgumentException("No constant named "+name);
    }
}