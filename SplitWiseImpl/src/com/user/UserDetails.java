package com.user;

// TODO: Auto-generated Javadoc
/**
 * The Class UserDetails.
 */
public class UserDetails {

	/** The user id. */
	String userId;
	
	/** The name. */
	String name;
	
	/** The email. */
	String email;
	
	/** The phone number. */
	String phoneNumber;
	
	/**
	 * Instantiates a new user details.
	 *
	 * @param userId the user id
	 * @param name the name
	 * @param email the email
	 * @param phoneNumber the phone number
	 */
	public UserDetails(String userId, String name, String email, String phoneNumber) {
		super();
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}


	/**
	 * Gets the user id.
	 *
	 * @return the user id
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * Sets the user id.
	 *
	 * @param userId the new user id
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the email.
	 *
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the email.
	 *
	 * @param email the new email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Gets the phone number.
	 *
	 * @return the phone number
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * Sets the phone number.
	 *
	 * @param phoneNumber the new phone number
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	
}
