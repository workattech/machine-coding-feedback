package main.java.DB;

import main.java.PhoneBook.Model.User;

import java.util.HashMap;

public class InMemoryUserDB {
    HashMap<String, User> usersDb;

    public InMemoryUserDB() {
        this.usersDb = new HashMap<>();
    }

    public boolean contains(User user){
        return usersDb.containsKey(user.getUserId());
    }

    public User get(String userId){
        return usersDb.get(userId);
    }

    public boolean add(User user){
        if(usersDb.containsKey(user.getUserId()))
            return false;
        usersDb.put(user.getUserId(), user);
        return true;
    }

    public boolean update(User user){
        if(usersDb.containsKey(user.getUserId()) == false)
            return false;
        usersDb.put(user.getUserId(), user);
        return true;
    }

    public boolean delete(String userId){
        if(usersDb.containsKey(userId) == false)
            return false;
        usersDb.remove(userId);
        return true;
    }

    public boolean delete(User user){
        return  delete(user.getUserId());
    }
}
