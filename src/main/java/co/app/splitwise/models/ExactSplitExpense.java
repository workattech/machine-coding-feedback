package co.app.splitwise.models;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExactSplitExpense extends Expense{
	List<User> owedBy;
	List<Double> exactDivision;
	
	public ExactSplitExpense(Long id, User lendBy, Double amount, ExpenseType expenseType, List<User> owedBy, List<Double> exactDivision) {
		super(id, lendBy, amount, expenseType);
		this.owedBy = owedBy;
		this.exactDivision = exactDivision;
	}
}
