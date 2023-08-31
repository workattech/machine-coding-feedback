package com.pankaj.splitwise.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.pankaj.splitwise.models.User;

public class PrinterService {

	public PrinterService(SplitWiseService splitWiseService) {
		this.balanceSheet = splitWiseService.getBalanceSheet();
		this.userMap = splitWiseService.getUserMap();
	}

	private HashMap<User, HashMap<User, Double>> balanceSheet;
	private HashMap<String, User> userMap;

	public void display(String userName) {
		List<String> statements = new ArrayList<>();

		HashMap<User, Double> userBalance = balanceSheet.get(userMap.get(userName));
		for (Map.Entry<User, Double> entry : userBalance.entrySet()) {
			if (entry.getValue().equals(0.0))
				continue;
			statements.add(generateStatement(userMap.get(userName).getName(), entry.getKey().getName(), entry.getValue()));
		}
		if (statements.isEmpty())
			System.out.println("No Balances");
		else {
			statements.stream().forEach(statement -> {
				System.out.println(statement);
			});
		}
	}

	public void displayAll() {
		List<String> statements = new ArrayList<>();
		for (Map.Entry<User, HashMap<User, Double>> allBalances : balanceSheet.entrySet()) {
			for (Map.Entry<User, Double> userBalance : allBalances.getValue().entrySet()) {
				if (userBalance.getValue().equals(0.0))
					continue;
				statements.add(generateStatement(allBalances.getKey().getName(), userBalance.getKey().getName(), userBalance.getValue()));
			}
		}

		if (statements.isEmpty())
			System.out.println("No Balances");
		else {
			statements.stream().forEach(statement -> {
				System.out.println(statement);
			});
		}

	}

	private String generateStatement(String userFirst, String userSecond, Double amount) {
		if (amount > 0)
			return userSecond + " owes " + userFirst + ": " + Math.abs(amount);
		else
			return userFirst + " owes " + userSecond + ": " + Math.abs(amount);
	}

}
