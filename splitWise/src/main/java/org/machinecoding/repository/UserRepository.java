package org.machinecoding.repository;

import org.machinecoding.models.User;

import java.util.HashMap;
import java.util.Map;

public class UserRepository {
    private Map<String, User> userMap;

    public UserRepository() {
        userMap = new HashMap<>();
    }

    public void addUser(User user) {
        userMap.put(user.getId(), user);
    }

    public Map<String, User> getUserMap() {
        return userMap;
    }
}
