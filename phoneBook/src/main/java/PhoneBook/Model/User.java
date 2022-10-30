package main.java.PhoneBook.Model;

import main.java.PhoneBook.Constant.Fields;

import java.util.UUID;

public class User {
    String userId;
    String firstName;
    String lastName;
    String phoneNumber;

    public User(String userId, String firstName, String lastName, String phoneNumber) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    public User(String firstName, String lastName, String phoneNumber) {
        this.userId = UUID.randomUUID().toString();
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    public String getUserId() {
        return userId;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getField(Fields field){
        switch (field){
            case PHONE_NUMBER:
                return this.getPhoneNumber();
            case FIRST_NAME:
                return this.getFirstName();
            case LAST_NAME:
                return this.getLastName();
        }
        return null;
    }

    public void print(){
        System.out.println(this.userId + " " + this.firstName + " " + this.lastName + " " + this.phoneNumber);
    }
}
