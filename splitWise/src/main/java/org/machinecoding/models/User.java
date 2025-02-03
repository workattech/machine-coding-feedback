package org.machinecoding.models;

public class User {
    private final String id;
    private final String name;
    private final String email;
    private final String mobileNumber;

    public User(String id, String name, String email, String mobileNumber) {
        this.mobileNumber = mobileNumber;
        this.email = email;
        this.name = name;
        this.id = id;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }
}
