package com.pankaj.splitwise.services;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import com.pankaj.splitwise.models.PercentageSplit;
import com.pankaj.splitwise.models.Split;
import com.pankaj.splitwise.models.User;

public class SplitWiseService {
	private HashMap<User, HashMap<User, Double>> balanceSheet;
	private HashMap<String, User> userMap;

	public SplitWiseService() {
		balanceSheet = new HashMap<>();
		userMap = new HashMap<>();
	}

	public HashMap<User, HashMap<User, Double>> getBalanceSheet() {
		return balanceSheet;
	}

	public void setBalanceSheet(HashMap<User, HashMap<User, Double>> balanceSheet) {
		this.balanceSheet = balanceSheet;
	}

	public HashMap<String, User> getUserMap() {
		return userMap;
	}

	public void setUserMap(HashMap<String, User> userMap) {
		this.userMap = userMap;
	}

	public User getUser(String name) {
		return userMap.get(name);
	}

	public void addUser(String name, User user) {
		userMap.put(name, user);
		balanceSheet.put(user, new HashMap<>());
	}

	public void addExpense(String type, String paidBy, double amount, List<Split> splits) {
		createExpense(type, paidBy, amount, splits);
		splits.stream().forEach(split -> {
			HashMap<User, Double> givenToOthers = balanceSheet.get(getUser(paidBy));
			if (!givenToOthers.containsKey(split.getUser())) {
				givenToOthers.put(split.getUser(), 0.0);
			}
			givenToOthers.put(split.getUser(), givenToOthers.get(split.getUser()) + split.getAmount());

			HashMap<User, Double> balanceOfGivenUser = balanceSheet.get(split.getUser());

			if (!balanceOfGivenUser.containsKey(getUser(paidBy))) {
				balanceOfGivenUser.put(getUser(paidBy), 0.0);
			}
			balanceOfGivenUser.put(getUser(paidBy), balanceOfGivenUser.get(getUser(paidBy)) - split.getAmount());
		});
	}

	private void createExpense(String type, String paidBy, double amount, List<Split> splits) {
		// FOR 2 DECIMAL PLACES
		DecimalFormat f = new DecimalFormat("##.00");
		switch (type) {
		case "EQUAL":
			int totalUsers = splits.size();
			double dividedAmount = Double.parseDouble(f.format((double) amount / totalUsers));
			splits.stream().forEach(split -> {
				split.setAmount(dividedAmount);
			});
			return;
		case "EXACT":
			return;
		case "PERCENT":
			splits.stream().forEach(split -> {
				PercentageSplit percentageSplit = (PercentageSplit) split;
				double actualAmount = Double
						.parseDouble(f.format((double) (percentageSplit.getPercent() * amount / 100)));
				split.setAmount(actualAmount);
			});
			return;
		default:
			return;
		}

	}
}
