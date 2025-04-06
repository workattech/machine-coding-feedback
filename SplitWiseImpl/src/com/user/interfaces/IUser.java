package com.user.interfaces;

import com.user.UserDetails;

// TODO: Auto-generated Javadoc
/**
 * The Interface IUser.
 */
public interface IUser {
	
	/**
	 * Gets the user details.
	 *
	 * @param userId the user id
	 * @return the user details
	 */
	UserDetails getUserDetails();
	
	/**
	 * Update user details.
	 *
	 * @param userId the user id
	 * @param userDetails the user details
	 * @return true, if successful
	 */
	boolean updateUserDetails(UserDetails userDetails);
}
