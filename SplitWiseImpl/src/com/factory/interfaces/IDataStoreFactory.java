package com.factory.interfaces;

import com.dataStore.interfaces.IUserDataStore;
import com.dataStore.interfaces.IUserPairOwedAmountDataStore;

// TODO: Auto-generated Javadoc
/**
 * A factory for creating IDataStore objects.
 */
public interface IDataStoreFactory {
	
	/**
	 * Gets the user data store.
	 *
	 * @return the user data store
	 */
	IUserDataStore getUserDataStore();
	
	/**
	 * Gets the user pair owed amount data store.
	 *
	 * @return the user pair owed amount data store
	 */
	IUserPairOwedAmountDataStore getUserPairOwedAmountDataStore();
}
