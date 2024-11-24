package org.main;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.*;

@Getter
@Setter
public class GroupUsers {
    private HashMap<String, User> users;

    public GroupUsers() {
        this.users = new HashMap<>();
    }

    public User getUserByUserId(String userId) {
        return users.getOrDefault(userId, null);
    }

    public void addUserToGroup(User user) {
        users.put(user.getUserId(), user);
    }

    public void addUsersToGroup(ArrayList<User> userList) {
        for (User user : userList) {
            users.put(user.generateUserID(), user);
        }
    }

    public boolean checkIfUserIsPartOfGroup(String transUser) {
        return (getUserByUserId(transUser) != null);
    }
}
