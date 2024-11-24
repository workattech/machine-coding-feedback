package org.main;

public class TransactionSummary {
    private String transactorName;
    private Float transactionTotalVal;
    private Float userShare;

    public TransactionSummary(String transactorName, Float transactionTotalVal, Float userShare) {
        this.transactorName = transactorName;
        this.transactionTotalVal = transactionTotalVal;
        this.userShare = userShare;
    }

    public void printTransactionSummary() {
        System.out.println("User " + transactorName + " added Expense of total Val "+ transactionTotalVal+" your share is "+ userShare);
    }
}
