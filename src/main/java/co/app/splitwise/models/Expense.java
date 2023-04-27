package co.app.splitwise.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Expense {
	Long id;
	User lendBy;
	Double amount;
	ExpenseType expenseType;
}
