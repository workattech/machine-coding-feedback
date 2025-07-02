package splitwise.model;

import java.util.UUID;

public class User {
    String name;
    String email;
    int phoneNumber;
    int id;
    double expenses;

    public User(String name, String email, int phoneNumber){
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.id = UUID.randomUUID().hashCode();
        this.expenses = 0;
    }

    public String getName(){
        return this.name;
    }

    public String getEmail(){
        return this.email;
    }

    public int getPhone(){
        return this.phoneNumber;
    }

    public int getId(){
        return this.id;
    }

    public double getExpenses(){
        return this.expenses;
    }
}
