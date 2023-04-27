package co.app.splitwise.models;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class EqualSplitExpense extends Expense{
	List<User> owedBy;
	
	public EqualSplitExpense(Long id, User lendBy, Double amount, ExpenseType expenseType, List<User> owedBy) {
		super(id, lendBy, amount, expenseType);
		this.owedBy = owedBy;
	}
}
