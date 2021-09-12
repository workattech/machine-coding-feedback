package com.main.ledgercompany.models;

public class Payment {
  int paymentAmount;
  int paymentMonth;

  public Payment(int paymentAmount, int paymentMonth) {
    this.paymentAmount = paymentAmount;
    this.paymentMonth = paymentMonth;
  }

  public int getPaymentAmount() {
    return paymentAmount;
  }

  public void setPaymentAmount(int paymentAmount) {
    this.paymentAmount = paymentAmount;
  }

  public int getPaymentMonth() {
    return paymentMonth;
  }

  public void setPaymentMonth(int paymentMonth) {
    this.paymentMonth = paymentMonth;
  }
}
