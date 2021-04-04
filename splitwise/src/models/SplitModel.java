package models;

import java.util.List;

public class SplitModel {

    private List<String> friends;

    private Double amount;

    private List<Double > percentage;


    private List<Double > exactAmounts;

    public List<String> getFriends() {
        return friends;
    }

    public void setFriends(List<String> friends) {
        this.friends = friends;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public List<Double> getPercentage() {
        return percentage;
    }

    public void setPercentage(List<Double> percentage) {
        this.percentage = percentage;
    }

    public List<Double> getExactAmounts() {
        return exactAmounts;
    }

    public void setExactAmounts(List<Double> exactAmounts) {
        this.exactAmounts = exactAmounts;
    }

    public SplitModel(List<String> friends, Double amount, List<Double> percentage, List<Double> exactAmounts) {
        this.friends = friends;
        this.amount = amount;
        this.percentage = percentage;
        this.exactAmounts = exactAmounts;
    }

    public SplitModel(){}

    @Override
    public String toString() {
        return "SplitModel{" +
                "friends=" + friends +
                ", amount=" + amount +
                ", percentage=" + percentage +
                ", exactAmounts=" + exactAmounts +
                '}';
    }
}
