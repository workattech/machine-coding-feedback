package domain;

import java.util.List;

public class RequestObject {
    private String transactionUser;
    private Double transactionAmount;
    private List<String> usersInvolved;
    private String expenseType;
    private List<Double> exactAmountList;
    private List<Integer> percentAmountList;

    public String getTransactionUser() {
        return transactionUser;
    }

    public void setTransactionUser(String transactionUser) {
        this.transactionUser = transactionUser;
    }

    public Double getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(Double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public List<String> getUsersInvolved() {
        return usersInvolved;
    }

    public void setUsersInvolved(List<String> usersInvolved) {
        this.usersInvolved = usersInvolved;
    }

    public String getExpenseType() {
        return expenseType;
    }

    public void setExpenseType(String expenseType) {
        this.expenseType = expenseType;
    }

    public List<Double> getExactAmountList() {
        return exactAmountList;
    }

    public void setExactAmountList(List<Double> exactAmountList) {
        this.exactAmountList = exactAmountList;
    }

    public List<Integer> getPercentAmountList() {
        return percentAmountList;
    }

    public void setPercentAmountList(List<Integer> percentAmountList) {
        this.percentAmountList = percentAmountList;
    }
}
