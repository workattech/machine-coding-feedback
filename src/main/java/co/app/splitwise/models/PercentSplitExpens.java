package co.app.splitwise.models;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PercentSplitExpens extends Expense{
	List<User> owedBy;
	List<Double> percentDivision;
	public PercentSplitExpens(long id, User lendBy, Double amountLended, ExpenseType expenseType,
			List<User> owedBy, List<Double> percentSplit) {
		super(id, lendBy, amountLended, expenseType);
		this.owedBy = owedBy;
		this.percentDivision = percentSplit;
	}
	
}
