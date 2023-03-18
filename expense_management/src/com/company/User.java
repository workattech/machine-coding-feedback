package com.company;

public class User {
    private static int idCount = 0;
    private Integer id;
    private String name;
    private String email;
    private String phoneNumber;

    public User(String name, String email, String phoneNumber){
        this.id = idCount++;
        this.setName(name);
        this.setEmail(email);
        this.setPhoneNumber(phoneNumber);
    }

    public Integer getId() {
        return id;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
