package src.splitwise;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class User {
    private String userId, name, email, mobileNumber;
    private Map<String, Double> balances = new ConcurrentHashMap<String, Double>();

    public Map<String, Double> getBalances() {
        return balances;
    }

    public User(String userId, String name, String email, String mobileNumber) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.mobileNumber = mobileNumber;
    }

    public synchronized void addTransaction(String userId, Double value) {
        if (balances.containsKey(userId)) {
            balances.put(userId, balances.get(userId) + value);
        } else {
            balances.put(userId, value);
        }
    }

    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

}
