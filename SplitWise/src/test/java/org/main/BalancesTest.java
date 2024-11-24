package org.main;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class BalancesTest {

    @Test
    void initlizeUsersBalancesMap() {
        ArrayList<User> users = new ArrayList<>();
        users.add(new User("M", "1212", "1@"));
        users.add(new User("A", "2212", "2@"));
        users.add(new User("H", "1254", "3@"));
        users.add(new User("E", "5415", "4@"));
        GroupUsers groupUsers = new GroupUsers();
        groupUsers.addUsersToGroup(users);
        Balances balances = new Balances(Currencies.RUPEE);
        balances.initlizeUsersBalancesMap(groupUsers);
        Group group = new Group("Test", groupUsers, balances);

        StringFloatMap trans1 = new StringFloatMap();
        trans1.put("A2212", 200f);
        trans1.put("H1254", 200f);
        trans1.put("E5415", 200f);
        balances.printGroupBalances();
//        balances.updateBalances("M1212", trans1, 1000f);
        balances.printBalancesMap();
        System.out.println("A2212 and M1212");
        balances.getBalanceForUserPrint("M1212", "A2212");
        System.out.println("M1212");
        balances.getBalanceForUserPrint("M1212");
        balances.printGroupBalances();
    }
}