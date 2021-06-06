package com.main.splitwise.models;

public class User {
  String id;
  String name;
  String emailId;

  public User(String id, String name, String emailId) {
    this.id = id;
    this.name = name;
    this.emailId = emailId;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmailId() {
    return emailId;
  }

  public void setEmailId(String emailId) {
    this.emailId = emailId;
  }
}
