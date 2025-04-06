package com.factory;

import com.dataStore.UserDataStore;
import com.dataStore.UserPairOwedAmountDataStore;
import com.dataStore.interfaces.IUserDataStore;
import com.dataStore.interfaces.IUserPairOwedAmountDataStore;
import com.factory.interfaces.IDataStoreFactory;

// TODO: Auto-generated Javadoc
/**
 * A factory for creating DataStore objects.
 */
public class DataStoreFactory implements IDataStoreFactory {
	
	/** The user data store. */
	private IUserDataStore userDataStore;
	
	/** The user pair owed amount data store. */
	private IUserPairOwedAmountDataStore userPairOwedAmountDataStore;
	
	/**
	 * Gets the user data store.
	 *
	 * @return the user data store
	 */
	@Override
	public IUserDataStore getUserDataStore() {
		if (userDataStore == null) {
			this.userDataStore = new UserDataStore();
		}
		return this.userDataStore;
	}

	/**
	 * Gets the user pair owed amount data store.
	 *
	 * @return the user pair owed amount data store
	 */
	@Override
	public IUserPairOwedAmountDataStore getUserPairOwedAmountDataStore() {
		if (userPairOwedAmountDataStore == null) {
			this.userPairOwedAmountDataStore = new UserPairOwedAmountDataStore();
		}
		
		return this.userPairOwedAmountDataStore;
	}
	
}
