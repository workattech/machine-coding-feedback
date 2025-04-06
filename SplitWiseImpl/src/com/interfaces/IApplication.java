package com.interfaces;

import java.util.List;

import com.enums.SplitStrategyType;
import com.strategies.interfaces.ISplitInput;
import com.strategies.splitObjects.SplitResult;

// TODO: Auto-generated Javadoc
/**
 * The Interface IApplication.
 */
public interface IApplication {
	
	/**
	 * Adds the expense.
	 *
	 * @param expenseInput the expense input
	 * @return true, if successful
	 */
	boolean addExpense(ISplitInput splitInput);
	
	/**
	 * Gets the balance for user.
	 *
	 * @param userId the user id
	 * @return the balance for user
	 */
	SplitResult getBalanceForUser(String userId);
	
	/**
	 * Gets the all balances.
	 *
	 * @return the all balances
	 */
	SplitResult getAllBalances();
	
	/**
	 * Gets the strategies name.
	 *
	 * @return the strategies name
	 */
	List<SplitStrategyType> getStrategiesName();
}
