package com.dataStore.interfaces;

import com.strategies.splitObjects.SplitResult;

// TODO: Auto-generated Javadoc
/**
 * The Interface IUserPairOwedAmountDataStore.
 */
public interface IUserPairOwedAmountDataStore {
	
	/**
	 * Update amount.
	 *
	 * @param userId1 the user id 1
	 * @param userId2 the user id 2
	 * @param amount the amount
	 * @return true, if successful
	 */
	boolean updateAmount(String userId1, String userId2, double amount);
	
	/**
	 * Gets the balances for user.
	 *
	 * @param userId the user id
	 * @return the balances for user
	 */
	SplitResult getBalancesForUser(String userId);
	
	/**
	 * Gets the balances for all users.
	 *
	 * @return the balances for all users
	 */
	SplitResult getBalancesForAllUsers();
	
	/**
	 * Update amount for entries.
	 *
	 * @param splitResult the split result
	 * @return true, if successful
	 */
	boolean updateAmountForEntries(SplitResult splitResult);
}
