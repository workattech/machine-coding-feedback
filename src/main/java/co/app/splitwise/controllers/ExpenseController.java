package co.app.splitwise.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import co.app.splitwise.exceptions.InvalidExpenseException;
import co.app.splitwise.exceptions.UserNotFound;
import co.app.splitwise.models.Expense;
import co.app.splitwise.services.ExpenseManagerService;

@Component
public class ExpenseController {
	List<Expense> expenseList; 
	ExpenseManagerService expenseManager;
	
	public ExpenseController(ExpenseManagerService expenseManger) {
		expenseList = new ArrayList<Expense>();
		this.expenseManager = expenseManger;
	}
	public void addExpense(Expense expense) throws InvalidExpenseException {
		expenseList.add(expense);
		expenseManager.addExpense(expense);
	}
	public void show() throws UserNotFound {
		expenseManager.show();
	}
	
	public void show(String userId) throws UserNotFound {
		expenseManager.show(userId);
	}
}
