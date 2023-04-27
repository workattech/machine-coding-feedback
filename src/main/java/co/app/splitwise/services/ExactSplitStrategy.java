package co.app.splitwise.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import co.app.splitwise.exceptions.InvalidExpenseException;
import co.app.splitwise.models.ExactSplitExpense;
import co.app.splitwise.models.Expense;
import co.app.splitwise.models.User;

public class ExactSplitStrategy implements SplitStrategy {
	Expense expense;
	Map<String,Map<String,Double>> usersExpenseMap;
	public ExactSplitStrategy(Expense expense, Map<String, Map<String, Double>> usersExpenseMap) {
		this.expense = expense;
		this.usersExpenseMap = usersExpenseMap;
	}

	@Override
	public boolean execute() throws InvalidExpenseException {
		ExactSplitExpense exSplitExpense = (ExactSplitExpense) expense;
		User lendBy = expense.getLendBy();
		List<User> owedBy = exSplitExpense.getOwedBy();
		List<Double> exactSplitAmounts = exSplitExpense.getExactDivision();
		Double sum = (double) 0;
		for(Double num : exactSplitAmounts) {
			sum+= num;
		}
		if(!sum.equals(expense.getAmount())) {
			throw new InvalidExpenseException("Split Amount sum is not equal to Total Amount");
		}
		Map<String,Double> userExpenseMap = usersExpenseMap.get(lendBy.getUserId());
		if(userExpenseMap == null) {
			userExpenseMap = new HashMap<String, Double>();
			usersExpenseMap.put(lendBy.getUserId(), userExpenseMap);
		}
		for(int i=0; i<owedBy.size();i++) {
			if(!(owedBy.get(i).getUserId().equals(lendBy.getUserId()))) {
				userExpenseMap.merge(owedBy.get(i).getUserId(), exactSplitAmounts.get(i), Double::sum);
			}
		}
		return true;
	}

}
