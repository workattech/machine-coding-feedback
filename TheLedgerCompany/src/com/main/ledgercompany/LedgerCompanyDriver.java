package com.main.ledgercompany;

import com.main.ledgercompany.models.Borrower;
import com.main.ledgercompany.models.Payment;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LedgerCompanyDriver {
  public static  void main(String[] args){
    LedgerCompanyService ledgerCompanyService = new LedgerCompanyService();
    List<Borrower> borrowers = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    String filePath = sc.nextLine();
    File file =
        new File(filePath);
    Scanner scanner = null;
    try {
      scanner = new Scanner(file);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
      while(scanner.hasNextLine()){

      String command = scanner.nextLine();
      String[] commands = command.split(" ");
      String commandType = commands[0];
      String bankName = "";
      String name = "";
      switch (commandType) {
        case "LOAN":
          bankName = commands[1];
          name = commands[2];
          int principal = Integer.parseInt(commands[3]);
          int timePeriod = Integer.parseInt(commands[4]);
          double ratePercent = Double.parseDouble(commands[5]);
          Borrower borrower = new Borrower(name, bankName, principal, timePeriod, ratePercent);
          borrowers.add(borrower);
          break;
        case "PAYMENT":
          bankName = commands[1];
          name = commands[2];
          int paymentAmount = Integer.parseInt(commands[3]);
          int paymentMonth = Integer.parseInt(commands[4]);
          addPlayers(borrowers, bankName, name, paymentAmount, paymentMonth);
          break;
        case "BALANCE":
          bankName = commands[1];
          name = commands[2];
          int duration = Integer.parseInt(commands[3]);
          for(Borrower eachBorrower : borrowers){
            if (eachBorrower.getBankName().equals(bankName) && eachBorrower.getName().equals(name)) {
              ledgerCompanyService.showBalance(eachBorrower, duration);
            }
          }
          break;
      }
    }
  }
  public static void addPlayers(List<Borrower> borrowers, String bankName,String name,int paymentAmount,int paymentMonth){
    for(Borrower eachBorrower : borrowers){
      if(eachBorrower.getBankName().equals(bankName) && eachBorrower.getName().equals(name)){
        Payment payment = new Payment(paymentAmount, paymentMonth);
        if(eachBorrower.getPayments() == null) {
          eachBorrower.setPayments(new ArrayList<>());
        }
        eachBorrower.getPayments().add(payment);
      }
    }
  }
}
