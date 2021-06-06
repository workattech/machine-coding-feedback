package com.main.splitwise.models;

public class Split {
  private User user;
  private int individualAmount;

  public Split(User user, int individualAmount) {
    this.user = user;
    this.individualAmount = individualAmount;
  }

  public Split(User user) {
    this.user = user;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public int getIndividualAmount() {
    return individualAmount;
  }

  public void setIndividualAmount(int individualAmount) {
    this.individualAmount = individualAmount;
  }
}
