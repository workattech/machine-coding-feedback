package co.app.splitwise.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import co.app.splitwise.exceptions.InvalidExpenseException;
import co.app.splitwise.exceptions.UserNotFound;
import co.app.splitwise.models.Expense;
import co.app.splitwise.models.ExpenseType;

@Component
public class ExpenseManagerService {
	Map<String,Map<String,Double>> userexpenseMap;
	SplitStrategy splitStrategy;
	
	public ExpenseManagerService() {
		userexpenseMap = new HashMap<String, Map<String,Double>>();
	}
	public void addExpense(Expense expense) throws InvalidExpenseException{
		if(expense.getExpenseType() == ExpenseType.EQUAL) {
			splitStrategy = new EqualSplitStrategy(expense,userexpenseMap);
			splitStrategy.execute();
		}else if(expense.getExpenseType() == ExpenseType.EXACT) {
			splitStrategy = new ExactSplitStrategy(expense,userexpenseMap);
			splitStrategy.execute();
		}else if(expense.getExpenseType() == ExpenseType.PERCENT) {
			splitStrategy = new PercentSplitStrategy(expense,userexpenseMap);
			splitStrategy.execute();
		}else {
			throw new InvalidExpenseException("Incorrect Expense Type");
		}
	}
	public void show() throws UserNotFound {
		for(String userId : userexpenseMap.keySet()) {
			show(userId);
		}
	}
	public void show(String userId) throws UserNotFound {
		Map<String,Double> map = userexpenseMap.get(userId);
		if(map == null) {
			throw new UserNotFound("User:"+userId+" Not Found");
		}
		for(Map.Entry<String, Double> entry : map.entrySet()) {
			System.out.println(entry.getKey()+" owes "+userId+": "+entry.getValue());
		}
	}
	

}
