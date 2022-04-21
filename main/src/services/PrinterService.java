package services;

import model.User;

import java.util.Map;

public class PrinterService {

    public static void printUserBalace(User user) {
        Map<User,Double> userPending = user.getPassbook();
        if(userPending.isEmpty()) {
            printNoBalances();
            return;
        }
        for (Map.Entry<User,Double> entry : userPending.entrySet()) {
            printBalance(user,entry.getKey(),entry.getValue());
        }
    }
    public static void printBalance(User paidBy,User paidTo,Double amount) {
        if(amount > 0.0) {
            System.out.println(paidBy.getName() + " owes " + paidTo.getName() + ": " + amount);
        }
    }

    public  static void printNoBalances(){
        System.out.println("No Balances");
    }

}
