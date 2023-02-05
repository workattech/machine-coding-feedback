package org.example;
// Java program to find 4 elements
// with given sum
import java.util.*;
class User {
    Integer uid, mobNo;
    String name, email;

    HashMap<Integer, Integer> dues; // HashMap< UserID , Amount Due >

    void recordTransaction (User toUser, int amount) {
        if(dues.containsKey(toUser.uid)){
            dues.put(toUser.uid, dues.get(toUser.uid) + amount);
        }
        else dues.put(toUser.uid, amount);
    }

    @Override
    public String toString(){
        return uid.toString() + " " + dues.toString();
    }

}

abstract class Expense {
    User fromUser;
    int numberOfUsers;
    Distribution distributionType;
    Integer totalAmount;

    abstract void performTransaction();


    //Factory method to create transaction
    static Expense createTransaction(User fromUser, Distribution distributionType, List<User> toUsers, int totalAmount, List<Integer> amountDistribution) {
        if(distributionType == Distribution.EQUAL){
            Expense transaction = new EqualExpense();
            transaction.numberOfUsers = toUsers.size();
            transaction.distributionType = distributionType;
            transaction.fromUser = fromUser;
            transaction.totalAmount = totalAmount;
            transaction.toUsers = toUsers;
            return transaction;
        }

        else if (distributionType == Distribution.PERCENTAGE) {
            Expense transaction = new PercentageExpense();
            transaction.numberOfUsers = toUsers.size();
            transaction.distributionType = distributionType;
            transaction.fromUser = fromUser;
            transaction.totalAmount = totalAmount;
            transaction.amountDistribution = amountDistribution;
            return transaction;
        }

        else if (distributionType == Distribution.EXACT_AMOUNT) {
            Expense transaction = new ExactExpense();
            transaction.numberOfUsers = toUsers.size();
            transaction.distributionType = distributionType;
            transaction.fromUser = fromUser;
            transaction.totalAmount = totalAmount;
            transaction.amountDistribution = amountDistribution;
            transaction.toUsers = toUsers;
            return transaction;
        }
        return null;
    }
}

class PercentageExpense extends Expense {
    List<User> toUsers;
    List<Integer> amountDistribution;

    @Override
    void performTransaction() {
        for(int i=0; i < this.numberOfUsers;i++){
            User toUser = this.toUsers.get(i);
            this.fromUser.recordTransaction(toUser, (this.totalAmount * amountDistribution.get(i)) / 100);
            toUser.recordTransaction(fromUser, -1 * (this.totalAmount * amountDistribution.get(i)) / 100);
        }
    }
}
class ExactExpense extends Expense {
    List<User> toUsers;
    List<Integer> amountDistribution;

    @Override
    void performTransaction() {
        for(int i=0; i < this.numberOfUsers; i++) {
            User toUser = toUsers.get(i);
            int amount = amountDistribution.get(i);
            fromUser.recordTransaction(toUser, amount);
            toUser.recordTransaction(fromUser, -1 * amount);
        }
    }
}
class EqualExpense extends Expense {
    List<User> toUsers;

    @Override
    void performTransaction() {
        int amountPerHead = this.totalAmount/ this.numberOfUsers;
        for(int i=0; i < this.numberOfUsers;i++){
            User toUser = this.toUsers.get(i);
            this.fromUser.recordTransaction(toUser, amountPerHead);
            toUser.recordTransaction(fromUser, -1 * amountPerHead);
        }
    }
}

enum Distribution {
    PERCENTAGE,
    EXACT_AMOUNT,
    EQUAL
}


public class Main2 {
    public static  void main(String args[]) {
        User user1 = new User(); user1.uid = 1; user1.name = "xyz"; user1.dues = new HashMap<>();
        User user2 = new User(); user2.uid = 2; user2.name = "abc"; user2.dues = new HashMap<>();
        User user3 = new User(); user3.uid = 3; user3.name = "pqr"; user3.dues = new HashMap<>();

        Expense object = Expense.createTransaction(user1, Distribution.EQUAL, new ArrayList<User>(){{add(user2);add(user3);}}, 1000, null);
        if(object == null) System.out.println( "cannot create transaction");
        object.performTransaction();

        object = Expense.createTransaction(user2, Distribution.EXACT_AMOUNT, new ArrayList<User>(){{add(user1);add(user3);}}, 1000, new ArrayList<Integer>(){{add(200);add(800);}});
        if(object == null) System.out.println( "cannot create transaction 2");
        object.performTransaction();

        System.out.println(user1);
        System.out.println(user2);
        System.out.println(user3);
    }

}
