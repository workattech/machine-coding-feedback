package com.pankaj.splitwise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.pankaj.splitwise.models.User;
import com.pankaj.splitwise.models.EqualSplit;
import com.pankaj.splitwise.models.ExactSplit;
import com.pankaj.splitwise.models.PercentageSplit;
import com.pankaj.splitwise.models.Split;
import com.pankaj.splitwise.services.PrinterService;
import com.pankaj.splitwise.services.SplitWiseService;

public class SplitWiseMain {

	public static void main(String[] args) {
		System.out.println("SPLIT-WISE");
		try (Scanner io = new Scanner(System.in)) {
			SplitWiseService splitWiseService = new SplitWiseService();

			User user1 = new User("u1", "u1@gmail.com", "9890098900");
			User user2 = new User("u2", "u2@gmail.com", "9999999999");
			User user3 = new User("u3", "u3@gmail.com", "9898989899");
			User user4 = new User("u4", "u4@gmail.com", "8976478292");

			splitWiseService.addUser("u1", user1);
			splitWiseService.addUser("u2", user2);
			splitWiseService.addUser("u3", user3);
			splitWiseService.addUser("u4", user4);

			PrinterService printerService = new PrinterService(splitWiseService);
			System.out.println();
			while (io.hasNextLine()) {
				String input = io.nextLine();
				String[] commands = input.trim().split(" ");
				String type = commands[0];
				System.out.println();
				switch (type) {
				case "EXPENSE":
					String userName = commands[1];
					double amountSpend = Double.parseDouble(commands[2]);
					int totalMembers = Integer.parseInt(commands[3]);
					List<Split> splits = new ArrayList<>();
					int expenseIndex = 3 + totalMembers + 1;
					String way = commands[expenseIndex];
					switch (way) {
					case "EQUAL":
						for (int i = 0; i < totalMembers; i++) {
							splits.add(new EqualSplit(splitWiseService.getUser(commands[4 + i])));
						}
						splitWiseService.addExpense(way, userName, amountSpend, splits);
						break;
					case "EXACT":
						for (int i = 0; i < totalMembers; i++) {
							User user = splitWiseService.getUser(commands[4 + i]);
							splits.add(new ExactSplit(user, Double.parseDouble(commands[expenseIndex + i + 1])));
						}
						splitWiseService.addExpense(way, userName, amountSpend, splits);

						break;
					case "PERCENT":
						for (int i = 0; i < totalMembers; i++) {
							User user = splitWiseService.getUser(commands[4 + i]);
							splits.add(new PercentageSplit(user, Double.parseDouble(commands[expenseIndex + i + 1])));
						}
						splitWiseService.addExpense(way, userName, amountSpend, splits);
						break;
					}
					break;
				case "SHOW":
					if (commands.length == 1) {
						printerService.displayAll();
					} else
						printerService.display(commands[1]);

					break;
				case "QUIT":
					System.out.println("Quiting...");
					return;
				default:
					System.out.println("No Expected Argument Found");
					break;
				}
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
	}

}
