package org.main;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        String line;
        String[] input;
        String filePath = "C:\\Users\\mahes\\Exercism\\java\\SplitWise\\src\\main\\resources\\transactions.txt";
        Scanner scanner = new Scanner(Path.of(filePath));

        ArrayList<User> users = new ArrayList<>();
        users.add(new User("M", "1212", "1@"));
        users.add(new User("A", "2212", "2@"));
        users.add(new User("H", "1254", "3@"));
        users.add(new User("E", "5415", "4@"));
        GroupUsers groupUsers = new GroupUsers();
        groupUsers.addUsersToGroup(users);
        Balances balances = new Balances(Currencies.RUPEE);
        balances.initlizeUsersBalancesMap(groupUsers);
        Group group = new Group("Trip1", groupUsers, balances);

        while (scanner.hasNextLine()) {
            line = scanner.nextLine();
            line = line.strip();
            input = line.split(" ");
            ArrayList<String> processLine = new ArrayList<>(List.of(input));
            Transaction transaction = new Transaction();

            if (processLine.get(0).equals("SHOW")) {
                if (input.length != 1) {
                    group.getBalances().getBalanceForUserPrint(processLine.get(1).strip());
                    System.out.println("--- = ---");
                } else {
                    group.getBalances().printGroupBalances();
                    System.out.println("--- = ---");
                }
            } else if (processLine.get(0).equals("EXPENSE")) {
                processLine.remove(0);
                transaction.processTransaction(processLine, group);
                group.getGroupUsers().getUserByUserId(processLine.get(0)).printTransactions();
                System.out.println("--- = ---");
            }
        }
        group.getBalances().printBalancesMap();
        group.getBalances().processSimplifiedBalances(groupUsers);
        group.getBalances().printSimpliedBalances();
    }
}