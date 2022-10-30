package main.java.PhoneBook.Model;

import java.util.List;

public class SearchResponse {
    List<User> users;
    int count;

    public SearchResponse(List<User> users) {
        this.users = users;
        this.count = users.size();
    }

    public List<User> getUsers() {
        return users;
    }

    public int getCount() {
        return count;
    }

    public void print(){
        System.out.println("Count of users:- " + count);
        users.forEach(user -> {
            System.out.println(user.getUserId() + " " + user.getFirstName() + " " + user.getLastName() + " " +  user.getPhoneNumber() );
        });
        System.out.println("");
    }
}
