package com.pankaj.splitwise.models;

import java.util.List;

public class PercentageExpense extends Expense{

	public PercentageExpense(double amount, User paidBy, List<Split> splits) {
		super(amount, paidBy, splits);
	}

	@Override
	public boolean validate() {
		return false;
	}

}
