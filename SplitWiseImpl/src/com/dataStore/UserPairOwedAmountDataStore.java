package com.dataStore;

import java.util.HashMap;
import java.util.Iterator;

import com.dataStore.interfaces.IUserPairOwedAmountDataStore;
import com.strategies.splitObjects.SplitResult;

// TODO: Auto-generated Javadoc
/**
 * The Class UserPairOwedAmountDataStore.
 */
public class UserPairOwedAmountDataStore implements IUserPairOwedAmountDataStore {
	
	/** The owed by map. */
	private HashMap<String, HashMap<String, Double>> owedByMap = new HashMap<String, HashMap<String,Double>>();
	
	/** The owes to map. */
	private HashMap<String, HashMap<String, Double>> owesToMap = new HashMap<String, HashMap<String,Double>>();


	/**
	 * Update amount.
	 *
	 * @param userId1 the user id 1
	 * @param userId2 the user id 2
	 * @param amount the amount
	 * @return true, if successful
	 */
	@Override
	public boolean updateAmount(String userId1, String userId2, double amount) {
		double amountOwed = amount;
		if (this.owedByMap.containsKey(userId2) && this.owedByMap.get(userId2).containsKey(userId1)) {
			amountOwed = owedByMap.get(userId2).get(userId1) - amount;
			
			if (amountOwed > 0) {
				this.owedByMap.get(userId2).put(userId1, amountOwed);
				
				this.owesToMap.get(userId1).put(userId2, amountOwed);
				
				return true;
			}
			
			this.owedByMap.get(userId2).remove(userId1);
			this.owesToMap.get(userId1).remove(userId2);
			
			amountOwed *= -1.0;
		}
		
		
		
		if (!this.owedByMap.containsKey(userId1)) {
			this.owedByMap.put(userId1, new HashMap<String, Double>());
		}
		
		if (!this.owedByMap.get(userId1).containsKey(userId2)) {
			this.owedByMap.get(userId1).put(userId2, 0.0);
		}
		
		this.owedByMap.get(userId1).put(userId2, this.owedByMap.get(userId1).get(userId2) + amountOwed);
		
		if (!owesToMap.containsKey(userId2)) {
			this.owesToMap.put(userId2, new HashMap<String, Double>());
		}
		
		if (!this.owesToMap.get(userId2).containsKey(userId1)) {
			this.owesToMap.get(userId2).put(userId1, 0.0);
		}
		
		this.owesToMap.get(userId2).put(userId1, this.owesToMap.get(userId2).get(userId1) + amountOwed);
		
		
			
		return true;
	}

	/**
	 * Gets the balances for user.
	 *
	 * @param userId the user id
	 * @return the balances for user
	 */
	@Override
	public SplitResult getBalancesForUser(String userId) {
		SplitResult result = new SplitResult();
		
		result.getOwedBy().put(userId, this.owedByMap.get(userId));
		
		result.getOwedTo().put(userId, this.owesToMap.get(userId));
		
		return result;
	}

	/**
	 * Gets the balances for all users.
	 *
	 * @return the balances for all users
	 */
	@Override
	public SplitResult getBalancesForAllUsers() {
		return new SplitResult(owedByMap, null, null, null);
	}

	/**
	 * Update amount for entries.
	 *
	 * @param splitResult the split result
	 * @return true, if successful
	 */
	@Override
	public boolean updateAmountForEntries(SplitResult splitResult) {
		Iterator<String> it = splitResult.getOwedBy().keySet().iterator();
		while (it.hasNext()) {
			String next = it.next();
			
			Iterator<String> it1 = splitResult.getOwedBy().get(next).keySet().iterator();
			
			while (it1.hasNext()) {
				String next1 = it1.next();
				
				this.updateAmount(next, next1, splitResult.getOwedBy().get(next).get(next1));
			}
		}
		
//		System.out.println("DS " + this.owedByMap + " " + this.owesToMap);
		
		return true;
	}
	
}
