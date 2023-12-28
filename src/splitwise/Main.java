package src.splitwise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    // A user class to represent a user(will have name, email, phone number, userId)
    // Create user u1, u2, u3, u4
    // A main application class which has logic of creating an expense, showing
    // balances etc.
    // App configuration which has list of users and graph of balances(in real world
    // maybe this is DB).
    public static void main(String[] args) throws Exception {
        Splitwise splitwise = new Splitwise();
        splitwise.createRandomUser("u1", "User1");
        splitwise.createRandomUser("u2", "User2");
        splitwise.createRandomUser("u3", "User3");
        splitwise.createRandomUser("u4", "User4");
        List<String> finalOutput = new ArrayList<String>();
        try (Scanner scanner = new Scanner(System.in)) {
            while (scanner.hasNextLine()) {
                String[] userInput = scanner.nextLine().split(" ");
                if (userInput[0].equals(UserOperation.EXPENSE.name())) {
                    splitwise.addExpense(userInput);
                } else if (userInput[0].equals(UserOperation.SHOW.name())) {
                    List<String> output = splitwise.showBalance(userInput);
                    for (String balance : output) {
                        finalOutput.add(balance);
                    }
                    if (output.size() == 0)
                        finalOutput.add("No balances");
                    finalOutput.add("\n");
                } else {
                    break;
                    // throw new InvalidAttributesException(String.format("Operation %s not
                    // supported", userInput[0]));
                }
            }
            for (String balance : finalOutput) {
                System.out.println(balance);
            }
        }
    }
}
