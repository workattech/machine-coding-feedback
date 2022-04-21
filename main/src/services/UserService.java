package services;

import model.User;

import java.util.ArrayList;
import java.util.Map;
import java.util.zip.DeflaterOutputStream;

public class UserService {
    private ArrayList<User> users;

    public UserService() {
        users = new ArrayList<User>();
    }

    public  void showBalanceForUser(String userName) {
        for (User user : users) {
            if (user.getName().equals(userName)) {
                PrinterService.printUserBalace(user);
                break;
            }
        }
    }

    public  void showAllBalances() {
        boolean isEmptyPassBook = true;

        for (User user : users) {
            if(!user.getPassbook().isEmpty()) {
                PrinterService.printUserBalace(user);
                isEmptyPassBook = false;
            }
        }
        if(isEmptyPassBook) PrinterService.printNoBalances();
    }

    public void addUser(User user) {
        users.add(user);
    }

    public User getUser(String name) {
        for(User user:users) {
            if(user.getName().equals(name)) {
                return user;
            }
        }
        return null;
    }

}