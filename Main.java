package org.example;
// Java program to find 4 elements
// with given sum
import org.example.enums.Distribution;
import org.example.models.User;
import org.example.services.ExpenseService;

import java.util.*;
public class Main {
    public static  void main(String[] args) {
        User user1 = new User(); user1.uid = 1; user1.name = "xyz"; user1.dues = new HashMap<>();
        User user2 = new User(); user2.uid = 2; user2.name = "abc"; user2.dues = new HashMap<>();
        User user3 = new User(); user3.uid = 3; user3.name = "pqr"; user3.dues = new HashMap<>();

        ExpenseService object = ExpenseService.createTransaction(user1, Distribution.EQUAL, new ArrayList<User>(){{add(user2);add(user3);}}, 1000, null);
        if(object == null) System.out.println( "cannot create transaction");
        object.performTransaction();

        object = ExpenseService.createTransaction(user2, Distribution.EXACT_AMOUNT, new ArrayList<User>(){{add(user1);add(user3);}}, 1000, new ArrayList<Integer>(){{add(200);add(800);}});
        if(object == null) System.out.println( "cannot create transaction 2");
        object.performTransaction();

        System.out.println(user1);
        System.out.println(user2);
        System.out.println(user3);
    }

}
