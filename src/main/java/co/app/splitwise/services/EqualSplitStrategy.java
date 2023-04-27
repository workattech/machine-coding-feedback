package co.app.splitwise.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import co.app.splitwise.models.EqualSplitExpense;
import co.app.splitwise.models.Expense;
import co.app.splitwise.models.User;

public class EqualSplitStrategy implements SplitStrategy{
	Expense expense;
	Map<String,Map<String,Double>> usersExpenseMap;
	public EqualSplitStrategy(Expense expense, Map<String, Map<String, Double>> usersExpenseMap) {
		this.expense = expense;
		this.usersExpenseMap = usersExpenseMap;
	}

	@Override
	public boolean execute() {
		EqualSplitExpense eqSplitExpense = (EqualSplitExpense) expense;
		User lendBy = expense.getLendBy();
		List<User> owedBy = eqSplitExpense.getOwedBy();
		Map<String,Double> userExpenseMap = usersExpenseMap.get(lendBy.getUserId());
		if(userExpenseMap == null) {
			userExpenseMap = new HashMap<String, Double>();
			usersExpenseMap.put(lendBy.getUserId(), userExpenseMap);
		}
		for(User user : owedBy) {
			if(!user.getUserId().equals(lendBy.getUserId())) {
				userExpenseMap.merge(user.getUserId(), (double) (expense.getAmount()/owedBy.size()), Double::sum);
			}
		}
		return true;
	}

}
