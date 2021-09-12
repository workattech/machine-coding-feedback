package com.main.ledgercompany;

import com.main.ledgercompany.models.Borrower;
import com.main.ledgercompany.models.Payment;

public class LedgerCompanyService {
  public void showBalance(Borrower borrower, int balanceFor){
    int principalAmount = borrower.getPrincipal();
    int timePeriod = borrower.getTimePeriod();
    double ratePercent = borrower.getRatePercent();
    int amount = calculateAmount(principalAmount, timePeriod, ratePercent);
    int numberOfEmi = calculateNoOfEmi(amount, timePeriod);
    int amountPerMonth = calculateEmi(amount, numberOfEmi);
    int result = amountPerMonth*balanceFor;
    result += checkforPayments(borrower, balanceFor);
    int timeLeft = checkforTimeIncludingPayments(borrower, amount, amountPerMonth, result);
    display(borrower.getBankName(), borrower.getName(), result,timeLeft );
  }
  public int checkforTimeIncludingPayments(Borrower borrower, int amount, int amountPerMonth, int result){
    int leftSum = amount-result;
    return (int)Math.ceil((double)leftSum/amountPerMonth);
  }
  public void display(String bankName, String playerName, int result, int timeLeft) {
    System.out.println(bankName + " " + playerName + " " + result + " " + timeLeft);
  }
  public int calculateAmount(int principalAmount, int timePeriod, double ratePercent){
    int interest = (int)Math.ceil(principalAmount*timePeriod*ratePercent)/100;
    return principalAmount+interest;
  }
  public int calculateNoOfEmi(int amount, int timePeriod){
    return 12*timePeriod;
  }
  public int calculateEmi(int amount, int numberOfEmi) {
    return (int) Math.ceil((double) amount / numberOfEmi);
  }
  public int checkforPayments(Borrower borrower, int balanceFor){
    int sum = 0;
    if(borrower.getPayments() == null)
      return 0;
    for(Payment payment : borrower.getPayments()){
      if(balanceFor >= payment.getPaymentMonth()){
        sum+=payment.getPaymentAmount();
      }
    }
    return sum;
  }
}
