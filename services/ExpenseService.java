package org.example.services;

import org.example.enums.Distribution;
import org.example.models.User;

import java.util.List;

public abstract class ExpenseService {
    User fromUser;
    int numberOfUsers;
    Distribution distributionType;
    Integer totalAmount;

    public abstract void performTransaction();


    //Factory method to create transaction
    public static ExpenseService createTransaction(User fromUser, Distribution distributionType, List<User> toUsers, int totalAmount, List<Integer> amountDistribution) {
        if(distributionType == Distribution.EQUAL){
            EqualExpense transaction = new EqualExpense();
            transaction.numberOfUsers = toUsers.size();
            transaction.distributionType = distributionType;
            transaction.fromUser = fromUser;
            transaction.totalAmount = totalAmount;
            transaction.toUsers = toUsers;
            return transaction;
        }

        else if (distributionType == Distribution.PERCENTAGE) {
            PercentageExpense transaction = new PercentageExpense();
            transaction.numberOfUsers = toUsers.size();
            transaction.distributionType = distributionType;
            transaction.fromUser = fromUser;
            transaction.totalAmount = totalAmount;
            transaction.amountDistribution = amountDistribution;
            return transaction;
        }

        else if (distributionType == Distribution.EXACT_AMOUNT) {
            ExactExpense transaction = new ExactExpense();
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

class PercentageExpense extends ExpenseService {
    List<User> toUsers;
    List<Integer> amountDistribution;

    @Override
    public void performTransaction() {
        for(int i=0; i < this.numberOfUsers;i++){
            User toUser = this.toUsers.get(i);
            this.fromUser.recordTransaction(toUser, (this.totalAmount * amountDistribution.get(i)) / 100);
            toUser.recordTransaction(fromUser, -1 * (this.totalAmount * amountDistribution.get(i)) / 100);
        }
    }
}
class ExactExpense extends ExpenseService {
    List<User> toUsers;
    List<Integer> amountDistribution;

    @Override
    public void performTransaction() {
        for(int i=0; i < this.numberOfUsers; i++) {
            User toUser = toUsers.get(i);
            int amount = amountDistribution.get(i);
            fromUser.recordTransaction(toUser, amount);
            toUser.recordTransaction(fromUser, -1 * amount);
        }
    }
}
class EqualExpense extends ExpenseService {
    List<User> toUsers;

    @Override
    public void performTransaction() {
        int amountPerHead = this.totalAmount/ this.numberOfUsers;
        for(int i=0; i < this.numberOfUsers;i++){
            User toUser = this.toUsers.get(i);
            this.fromUser.recordTransaction(toUser, amountPerHead);
            toUser.recordTransaction(fromUser, -1 * amountPerHead);
        }
    }
}
