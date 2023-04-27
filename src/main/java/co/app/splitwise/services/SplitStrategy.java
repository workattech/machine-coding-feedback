package co.app.splitwise.services;

import co.app.splitwise.exceptions.InvalidExpenseException;

public interface SplitStrategy {
	public boolean execute() throws InvalidExpenseException;
}
