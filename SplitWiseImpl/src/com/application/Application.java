package com.application;

import java.util.ArrayList;
import java.util.List;

import com.dataStore.interfaces.IUserPairOwedAmountDataStore;
import com.enums.SplitStrategyType;
import com.factory.interfaces.IDataStoreFactory;
import com.factory.interfaces.IStrategyListFactory;
import com.interfaces.IApplication;
import com.interfaces.IStrategyList;
import com.strategies.interfaces.ISplitInput;
import com.strategies.splitObjects.SplitResult;

/**
 * The Class Application.
 */
public class Application implements IApplication {
	
	/** The user pair owed amount data store. */
	private IUserPairOwedAmountDataStore userPairOwedAmountDataStore;
	
	/** The strategy list. */
	private IStrategyList strategyList;
	
	
	
	
	/**
	 * Instantiates a new application.
	 *
	 * @param dataStoreFactory the data store factory
	 * @param strategyListFactory the strategy list factory
	 * @param strategiesPresnt the strategies presnt
	 * @param inputReader the input reader
	 */
	Application(IDataStoreFactory dataStoreFactory, IStrategyListFactory strategyListFactory, List<String> strategiesPresnt) {

		this.userPairOwedAmountDataStore = dataStoreFactory.getUserPairOwedAmountDataStore();
		
		this.strategyList = strategyListFactory.getStrategyList(strategiesPresnt);
	}

	/**
	 * Adds the expense.
	 *
	 * @param expenseInput the expense input
	 * @return true, if successful
	 */
	@Override
	/**
	 * 
	 */
	public boolean addExpense(ISplitInput splitInput) {
		
		if (splitInput == null) {
			return false;
		}
		
		SplitResult splitResult = this.strategyList.getSplitStrategies().get(splitInput.getSplitInputType()).getFinalSplit(splitInput);
		
		// System.out.println("result " + splitResult.getOwedBy() + " " + splitResult.getOwedTo());
		
		return this.userPairOwedAmountDataStore.updateAmountForEntries(splitResult);
	}

	
	/**
	 * Gets the balance for user.
	 *
	 * @param userId the user id
	 * @return the balance for user
	 */
	@Override
	public SplitResult getBalanceForUser(String userId) {
		
		return this.userPairOwedAmountDataStore.getBalancesForUser(userId);
	}

	/**
	 * Gets the all balances.
	 *
	 * @return the all balances
	 */
	@Override
	public SplitResult getAllBalances() {
		// TODO Auto-generated method stub
		return this.userPairOwedAmountDataStore.getBalancesForAllUsers();
	}

	/**
	 * Gets the strategies name.
	 *
	 * @return the strategies name
	 */
	@Override
	public List<SplitStrategyType> getStrategiesName() {
		return new ArrayList<SplitStrategyType>(this.strategyList.getSplitStrategies().keySet());
	}

}
