package com.interfaces;

import java.util.List;

import com.user.UserDetails;

public interface IApplicationInterface {
	void instantiateApplication();
	
	List<String> runInputString(String input);
	
	boolean addNewUser(UserDetails userDetails);
}
