package model;

import java.util.Map;

public class User {
    private String name;
    private Map<User,Double> passbook;

    public User(String name, Map<User, Double> passbook) {
        this.name = name;
        this.passbook = passbook;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<User, Double> getPassbook() {
        return passbook;
    }

    public void setPassbook(Map<User, Double> passbook) {
        this.passbook = passbook;
    }

    public Double getBalanceForUser(User user) {
        return  passbook.getOrDefault(user.name,0.0);
    }

    public void updatePassBook(User user,Double amount) {
        if(name.equals(user.name))return;
        if(passbook.containsKey(user)) {
            Double currentAmount = passbook.get(user);
            Double newAmount = currentAmount + amount;
            passbook.replace(user,newAmount);
        }else {
            passbook.put(user,amount);
        }
    }

}
