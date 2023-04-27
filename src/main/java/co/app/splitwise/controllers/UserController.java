package co.app.splitwise.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import co.app.splitwise.models.User;

@Component
public class UserController {
	Map<String, User> users;
	
	public UserController() {
		users = new HashMap<>();
	}
	
	public User getUser(String userId) {
		return users.get(userId);
	}
	
	public User removeUser(String userId) {
		return users.remove(userId);
	}
	
	public User updateUser(String userId, User user) {
		return users.put(userId, user);
	}
	
	public User addUser(String userId, User user) {
		return users.put(userId, user);
	}
	
	public List<User> getAllUSers() {
		return (List<User>) users.values();
	}
}
