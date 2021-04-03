package models;

import java.util.Map;

public class User {
   private String userId;

   private Map<String  , Double > balanceSheet;


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Map<String, Double> getBalanceSheet() {
        return balanceSheet;
    }

    public void setBalanceSheet(Map<String, Double> balanceSheet) {
        this.balanceSheet = balanceSheet;
    }

    public User(String userId, Map<String, Double> balanceSheet) {
        this.userId = userId;
        this.balanceSheet = balanceSheet;
    }

    @Override
    public String toString() {
        return "models.User{" +
                "userId='" + userId + '\'' +
                ", balanceSheet=" + balanceSheet +
                '}';
    }
}
