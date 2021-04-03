package service.impl;

import models.User;
import service.BalanceService;
import utils.BalanceUtils;

import java.util.List;

public class BalanceServiceImpl implements BalanceService {


    @Override
    public void listAllBalances(List<User> users) {

       for(User user : users ) {

           if(user.getBalanceSheet() == null ){
                   System.out.println("No balances");
                   break;
           }

           for (String  friend : user.getBalanceSheet().keySet()) {
               System.out.println(user.getUserId() + " owes " + friend+ ": " + user.getBalanceSheet().get(friend));
           }
       }
    }

    @Override
    public void listBalance(User user) {

              if(user.getBalanceSheet() == null ){
                  System.out.println("No balances");
                  return;
              }

              for (String  friend : user.getBalanceSheet().keySet()){

                  System.out.println(user.getUserId() + " owes " + friend + ": " + user.getBalanceSheet().get(friend));
              }
    }
}
