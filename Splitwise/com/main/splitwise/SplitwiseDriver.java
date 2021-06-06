package com.main.splitwise;

import com.main.splitwise.models.Split;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SplitwiseDriver {
  public static  void main(String[] args){
    Scanner scanner = new Scanner(System.in);
    SplitwiseService splitwiseService = new SplitwiseService();

    while(true){
      String command = scanner.nextLine();
      String[] commands = command.split(" ");
      String instruction = commands[0];
      switch (instruction){
        case "SHOW":
          if(commands.length > 1){
            String userid = commands[1];
            splitwiseService.displaySplitForUser(userid);
          }
          else{
            splitwiseService.displaySplitForAllUsers();
          }
          break;
        case "EXPENSE":
          String paidBy = commands[1];
          int amountPaid = Integer.parseInt(commands[2]);
          int numberOfUsersSplit =  Integer.parseInt(commands[3]);
          String splitType = commands[numberOfUsersSplit+4];
          List<Split> splits = new ArrayList<>();
          for(int userNumber = 0; userNumber < numberOfUsersSplit; userNumber++){
            Split split = new Split(splitwiseService.getUsers().get(commands[userNumber+4]));
            splits.add(split);
          }
          switch (splitType) {
            case "EQUAL" -> splitwiseService.equalSplit(splits, amountPaid);
            case "EXACT" -> splitwiseService.exactSplit(splits, numberOfUsersSplit + 5, commands);
            case "PERCENT" -> splitwiseService
                .percentageSplit(splits, numberOfUsersSplit + 5, commands, amountPaid);
          }
          splitwiseService.createBalanceSheet(splits, paidBy);
      }
    }
  }
}
