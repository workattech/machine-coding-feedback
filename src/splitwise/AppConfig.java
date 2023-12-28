package src.splitwise;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class AppConfig {
    private static AppConfig instance;
    private Map<String, User> registeredUserIdToUser = new HashMap<String, User>();

    private AppConfig() {
    }

    public synchronized static AppConfig getInstance() {
        if (instance == null) {
            instance = new AppConfig();
        }
        return instance;
    }

    public boolean isUserRegistered(String userId) {
        if (registeredUserIdToUser.containsKey(userId))
            return true;
        return false;
    }

    public User getUserFromId(String userId) throws IllegalArgumentException {
        if (!isUserRegistered(userId))
            throw new IllegalArgumentException(String.format("Can't get a registered user with user id: %s", userId));
        return registeredUserIdToUser.get(userId);
    }

    public Map<String, User> getRegisteredUserIdToUser() {
        return Collections.unmodifiableMap(registeredUserIdToUser);
    }

    public synchronized void addNewUser(User user) throws IllegalArgumentException {
        if (isUserRegistered(user.getUserId()))
            throw new IllegalArgumentException(String.format("User already exists for userId: %s", user.getUserId()));
        this.registeredUserIdToUser.put(user.getUserId(), user);
    }
}
