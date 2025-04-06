package com.dataStore.interfaces;

import com.user.UserDetails;

/**
 * The Interface IUserDataStore.
 */
public interface IUserDataStore {
	
	/**
	 * Gets the user details.
	 *
	 * @param userId the user id
	 * @return the user details
	 */
	UserDetails getUserDetails(String userId);
	
	/**
	 * Adds the new user.
	 *
	 * @param userDetails the user details
	 * @return true, if successful
	 */
	boolean addNewUser(UserDetails userDetails);
	
	/**
	 * Delete user.
	 *
	 * @param userId the user id
	 * @return true, if successful
	 */
	boolean deleteUser(String userId);
	
	/**
	 * Update user details.
	 *
	 * @param userId the user id
	 * @param userDetails the user details
	 * @return true, if successful
	 */
	boolean updateUserDetails(String userId, UserDetails userDetails);
}
