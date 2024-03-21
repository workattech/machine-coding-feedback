import java.util.*;

import java.util.Map.Entry;

public class User {
    private String name;
    private String id;
    private Map<User, Double> currentRecord = new HashMap<>();

    public User(String name, String id) {
        this.name = name;
        this.id = id;
        currentRecord.clear();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void lendMoney(User lender, Double amount) {
        if (lender.getId() == this.id) {
            return;
        }
        Double currentRecordAmount = currentRecord.getOrDefault(lender, 0.00);
        if (Double.compare(currentRecordAmount + amount, 0.00) == 0) {
            this.currentRecord.remove(lender);
        } else {
            currentRecord.put(lender, currentRecordAmount + amount);
        }
    }

    public void borrowMoney(User provider, Double amount) {
        if (provider.id == this.id) {
            return;
        }
        Double currentRecordAmount = currentRecord.getOrDefault(provider, 0.00);
        if (Double.compare(currentRecordAmount - amount, 0.00) == 0) {
            currentRecord.remove(provider);
        } else {
            currentRecord.put(provider, currentRecordAmount - amount);
        }
    }

    public void showLenders() {
        for (Entry<User, Double> exp : currentRecord.entrySet()) {
            User lender = exp.getKey();
            Double oweAmount = exp.getValue();
            if (oweAmount < 0) {
                continue;
            }
            System.out.println(this.getName() + " owes " + lender.getName() + ": " + oweAmount);
        }
    }

    public void showAll() {
        showLenders();
        for (Entry<User, Double> exp : currentRecord.entrySet()) {
            User lender = exp.getKey();
            Double oweAmount = exp.getValue();
            if (oweAmount > 0)
                continue;
            System.out.println(lender.getName() + " owes " + this.getName() + ": " + Math.abs(oweAmount));
        }
    }

    public Boolean checkBalances() {
        return currentRecord.size() == 0;
    }

}
