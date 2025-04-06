package com.user;

import com.dataStore.interfaces.IUserDataStore;
import com.user.interfaces.IUser;

public class User implements IUser{
	private UserDetails userDetails;
	
	private String userId;
	
	private IUserDataStore userDataStore;
	

	public User(String userId, IUserDataStore userDataStore) {
		super();
		this.userId = userId;
		this.userDataStore = userDataStore;
	}

	@Override
	public UserDetails getUserDetails() {
		if (this.userDetails != null) {
			return this.userDetails;
		}
		
		this.userDetails = this.userDataStore.getUserDetails(this.userId);
		
		return this.userDetails;
	}

	@Override
	public boolean updateUserDetails(UserDetails userDetails) {
		boolean result = this.userDataStore.updateUserDetails(this.userId, userDetails);
		
		if (!result) {
			return false;
		}
		
		this.userDetails = this.userDataStore.getUserDetails(this.userId);
		
		return true;
		
	}
	
	
}
