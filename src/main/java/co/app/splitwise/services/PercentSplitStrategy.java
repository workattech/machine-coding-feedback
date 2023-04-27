package co.app.splitwise.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import co.app.splitwise.exceptions.InvalidExpenseException;
import co.app.splitwise.models.Expense;
import co.app.splitwise.models.PercentSplitExpens;
import co.app.splitwise.models.User;

public class PercentSplitStrategy implements SplitStrategy {
	Expense expense;
	Map<String,Map<String,Double>> usersExpenseMap;
	public PercentSplitStrategy(Expense expense, Map<String, Map<String, Double>> usersExpenseMap) {
		this.expense = expense;
		this.usersExpenseMap = usersExpenseMap;
	}

	@Override
	public boolean execute() throws InvalidExpenseException {
		PercentSplitExpens pSplitExpense = (PercentSplitExpens) expense;
		User lendBy = expense.getLendBy();
		List<User> owedBy = pSplitExpense.getOwedBy();
		List<Double> persentSplit = pSplitExpense.getPercentDivision();
		Double sum = (double) 0;
		for(Double num : persentSplit) {
			sum+= num;
		}
		if(sum != 100.0) {
			throw new InvalidExpenseException("Percent sum is not equal to 100");
		}
		Map<String,Double> userExpenseMap = usersExpenseMap.get(lendBy.getUserId());
		if(userExpenseMap == null) {
			userExpenseMap = new HashMap<String, Double>();
			usersExpenseMap.put(lendBy.getUserId(), userExpenseMap);
		}
		for(int i=0; i<owedBy.size();i++) {
			if(!(owedBy.get(i).getUserId().equals(lendBy.getUserId()))) {
				userExpenseMap.merge(owedBy.get(i).getUserId(), persentSplit.get(i)*pSplitExpense.getAmount()/100, Double::sum);
			}
		}
		return true;
	}

}
