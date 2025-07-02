package splitwise;

import snakesAndLadders.game.Game;
import snakesAndLadders.model.Player;
import splitwise.model.Expense;
import splitwise.model.Splitwise;
import splitwise.model.User;

import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Splitwise.");
        Scanner sc =  new Scanner(System.in);

        User user1 = new User("Charu", "charu@sweet.com", 12345);
        User user2 = new User("Rathi", "rathi@cute.com", 23456);
        User user3 = new User("Ishita", "ishita@logic.com", 34567);
        User user4 = new User("Kareena", "kareena@bitch.com", 45678);
        List<User> users = new ArrayList<>(Arrays.asList(user1, user2, user3, user4));
        Splitwise splitwise = new Splitwise(users);
        Map<String, User> map = new HashMap<>();
        for ( User u : users ) {
            map.put(u.getName().toUpperCase(), u);
        }
        System.out.println("Commands: SHOW, SHOW <User>, EXPENSE <Payer> <Amount> <EQUAL> <User1> <User2>..., EXIT");
        while(true) {
            System.out.println("> ");
            String input = sc.nextLine().trim();
            if (input.equalsIgnoreCase("EXIT")) {
                System.out.println("Bye bye!");
                break;
            }
            String[] commands = input.split(" ");
            if (commands[0].equalsIgnoreCase("SHOW")) {
                if (commands.length == 1) {
                    splitwise.showBalances();
                } else if (commands.length == 2) {
                    User user = map.get(commands[1].toUpperCase());
                    if (user == null) {
                        System.out.println("User " + commands[1].toUpperCase() + " not found!");
                        continue;
                    }
                    splitwise.showBalances(user);
                } else {
                    System.out.println("Wrong command!");
                    continue;
                }
            }
            if (commands[0].equalsIgnoreCase("EXPENSE")) {
                User payer = map.get(commands[1].toUpperCase());
                if (payer == null) {
                    System.out.println("User " + commands[1].toUpperCase() + " not found!");
                    continue;
                }
                double totalExpense = Double.parseDouble(commands[2]);
                int size = Integer.parseInt(commands[3]);
                List<User> payees = new ArrayList<>();
                for (int i = 0; i < size; i++) {
                    payees.add(map.get(commands[i+4].toUpperCase()));
                }
                Expense.ExpenseType type = Expense.ExpenseType.valueOf(commands[4+size]);
                List<Double> expenses = new ArrayList<>();
                for(int i=5+size;i<commands.length;i++){
                    expenses.add(Double.parseDouble(commands[i]));
                }
                Expense expense = new Expense(
                        payer,
                        totalExpense,
                        type,
                        payees,
                        expenses
                );
                splitwise.addExpense(expense);
            }
        }
    }
}