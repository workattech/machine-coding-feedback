package org.machinecoding.services;

import org.machinecoding.models.*;
import org.machinecoding.repository.BalanceRepository;
import org.machinecoding.repository.UserRepository;
import org.machinecoding.strategy.SplittingStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SplitWiseRunner {
    private BalanceRepository balanceRepository;
    private UserRepository userRepository;

    public SplitWiseRunner(){
        this.balanceRepository = new BalanceRepository();
        this.userRepository = new UserRepository();
    }

    public void addUser(User user){
        userRepository.addUser(user);
    }

    public Expense createExpense(Double amt, SplittingStrategy strategy){
        return new Expense(amt, strategy);
    }

    public void addTransaction(String paidBy, List<String> paidFor, Expense exp){
        User paidByUser = userRepository.getUserMap().get(paidBy);
        List<User> paidForUsers = paidFor.stream()
                .map(u->userRepository.getUserMap().get(u))
                .collect(Collectors.toList());

        Transaction transaction = new Transaction(paidByUser, paidForUsers, exp);
        transaction.populateSplitMap();

        addEntryInUserBalance(paidByUser, transaction);
    }

    public void addEntryInUserBalance(User paidBy, Transaction transaction) {
        for (Map.Entry<User, Double> entry : transaction.getSplits().entrySet()) {
            balanceRepository.addUserBalance(new UserPair(entry.getKey(), paidBy), entry.getValue());
        }
    }

    public void getAllBalances() {
        balanceRepository.getAllBalances();
    }

    public void getUserBalance(String userId) {
        balanceRepository.getUserBalance(userRepository.getUserMap().get(userId));
    }

}
