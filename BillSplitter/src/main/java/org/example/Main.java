package org.example;

import org.example.entities.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        User u1 = new User("u1", "u1", "", "");
        User u2 = new User("u2", "u2", "", "");
        User u3 = new User("u3", "u3", "", "");
        User u4 = new User("u4", "u4", "", "");

        User[] users = {u1, u2, u3, u4};

        UserBase userBase = new UserBase(users);


        //command
        //EXPENSE u1 1000 4 u1 u2 u3 u4 EQUAL
        //EXPENSE u1 1250 2 u2 u3 EXACT 370 880
        //EXPENSE u4 1200 4 u1 u2 u3 u4 PERCENT 40 20 20 20
        //SHOW u1
        Scanner sc = new Scanner(System.in);

        ExpenseEqualCommand expenseEqualCommand = new ExpenseEqualCommand();
        ExpenseExactCommand expenseExactCommand = new ExpenseExactCommand();
        ExpensePercCommand expensePercCommand= new ExpensePercCommand();
        ShowForUser showForUser= new ShowForUser();

        ShowCommand showCommand = new ShowCommand();
        while (sc.hasNext()) {
            String command = sc.nextLine();

            if (command.contains("EXPENSE") && command.contains("EXACT")) {

                expenseExactCommand.process(command, userBase);
            }

            else if (command.contains("EXPENSE") && command.contains("EQUAL")) {
                expenseEqualCommand.process(command, userBase);
            }
            else if (command.contains("EXPENSE") && command.contains("PERCENT")) {
                expensePercCommand.process(command, userBase);
            }

            else if (command.equals("SHOW")) {
                showCommand.process("SHOW", userBase);
            }
            else if (command.contains("SHOW")) {
                showForUser.process(command, userBase);
            }

        }

    }
}


//double ans
//            = Math.round(num * 10000000) / 10000000.0;
