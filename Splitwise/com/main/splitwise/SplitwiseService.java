package com.main.splitwise;

import static java.lang.Math.abs;

import com.main.splitwise.models.Split;
import com.main.splitwise.models.User;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SplitwiseService {
  Map<String, Map<String, Integer>> balanceSheet = new HashMap<>();
  Map<String, User> users = new HashMap<>();

  public SplitwiseService() {
    setUsers();
    setBalanceSheet();
  }

  public Map<String, User> getUsers() {
    return users;
  }

  public void setUsers() {
    users.put("u1", new User("u1", "User1", "abc@gmail.com"));
    users.put("u2" , new User("u2", "User2", "def@gmail.com"));
    users.put("u3" , new User("u3", "User3", "ghi@gmail.com"));
    users.put("u4", new User("u4", "User4", "jkl@gmail.com"));
  }
  public String getUserNameFromId(String userId){
    return this.getUsers().get(userId).getName();
  }

  public void setBalanceSheet(){
  this.balanceSheet.put("u1", new HashMap<>());
  this.balanceSheet.put("u2", new HashMap<>());
  this.balanceSheet.put("u3", new HashMap<>());
  this.balanceSheet.put("u4", new HashMap<>());
}



  public void createBalanceSheet(List<Split> splits, String paidBy) {
    for(Split split : splits){
      String paidTo = split.getUser().getId();
      Map<String, Integer> balances;
      balances = balanceSheet.get(paidBy);
      if(!balances.containsKey(paidTo)) {
          balances.put(paidTo, 0);
      }
        balances.put(paidTo, balances.get(paidTo)+ split.getIndividualAmount());
      balances = balanceSheet.get(paidTo);
      if(!balances.containsKey(paidBy)){
        balances.put(paidBy, 0);
      }
        balances.put(paidBy, balances.get(paidBy) - split.getIndividualAmount());
    }
  }
  public void equalSplit(List<Split> splits, int amountPaid) {
    int individualAmount = amountPaid/splits.size();
    for(Split split : splits){
      split.setIndividualAmount(individualAmount);
    }
  }

  public void exactSplit(List<Split> splits, int splitStartIndex, String[] commands) {
    for(int splitPerUser = splitStartIndex; splitPerUser <= commands.length-1; splitPerUser++){
      splits.get(splitPerUser-splitStartIndex).setIndividualAmount(Integer.parseInt(commands[splitPerUser]));
    }
  }

  public void percentageSplit(List<Split> splits, int splitStartIndex, String[] commands, int amountPaid) {
    for(int splitPerUser = splitStartIndex; splitPerUser <= commands.length-1;splitPerUser++){
      splits.get(splitPerUser-splitStartIndex).setIndividualAmount(Integer.parseInt(commands[splitPerUser])*amountPaid/100);
    }
  }

  public void displaySplitForUser(String userId) {
      Map<String, Integer> allBalances;
      allBalances = balanceSheet.get(userId);
    boolean isPresent = false;
    for(Map.Entry<String, Integer> balance : allBalances.entrySet()){
        if(balance.getValue() < 0){
          isPresent = true;
          System.out.println(
              getUserNameFromId(userId) + " owes " + getUserNameFromId(balance.getKey()) + ": " + abs(balance.getValue()));
        }
        if(balance.getValue() > 0){
          isPresent = true;
          System.out.println(getUserNameFromId(balance.getKey()) + " owes " + getUserNameFromId(userId) + ": " + abs(balance.getValue()));
        }
      }
    if(!isPresent){
      System.out.println("No balances");
    }
  }
  public void displaySplitForAllUsers(){
    boolean isPresent = false;
    for(Map.Entry<String, Map<String, Integer>> allBalances : balanceSheet.entrySet()){
      for(Map.Entry<String, Integer> balances : allBalances.getValue().entrySet()){
        if(balances.getValue() < 0){
          System.out.println(getUserNameFromId(allBalances.getKey()) + " owes " + getUserNameFromId(balances.getKey()) + ": " + abs(balances.getValue()));
          isPresent = true;
        }
      }
    }
    if(!isPresent){
      System.out.println("No balances");
    }
  }

}
