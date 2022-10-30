package main.java;

import main.java.PhoneBook.Model.*;
import main.java.PhoneBook.PhoneBook;

import static main.java.PhoneBook.Constant.Fields.*;
import static main.java.PhoneBook.Constant.SearchType.*;

public class Main {

//    private static SearchResponse searchUser(PhoneBook phoneBook, String type, String field, String query ){
//        System.out.println( "Search:- " + type + " " + field + " " + query);
//        SearchRequest searchRequest = new SearchRequest(type, field, query);
//        SearchResponse searchResponse = phoneBook.search(searchRequest);
//        searchResponse.print();
//        return searchResponse;
//    }


    public static void main(String[] args) {
//        PhoneBook phoneBook = new PhoneBook();
//
//        // add users
//        phoneBook.add(new User("Cat", "Tac", "1234567890"));
//        phoneBook.add(new User("Dogo", "DRod", "7223023580"));
//        phoneBook.add(new User("Dorid", "Drog", "8966850480"));
//        phoneBook.add(new User("Jakma", "joko", "92133023580"));
//        phoneBook.add(new User("Dogri", "Drogri", "9231301234"));
//        phoneBook.add(new User("Abhishek", "Malviya", "7223023580"));
//
//
//        searchUser(phoneBook, PARTIAL_SEARCH.name(), LAST_NAME.name(), "mal");
//        SearchResponse searchResponse = searchUser(phoneBook, COMPLETE_SEARCH.name(), FIRST_NAME.name(), "Abhishek");
//
//        if(searchResponse.getCount() > 0){
//            User user = searchResponse.getUsers().get(0);
//            String userId = user.getUserId();
//            User updatedUser = new User(userId, user.getFirstName(), "newLastName", user.getPhoneNumber());
//            Boolean res = phoneBook.update(updatedUser);
//            System.out.println( "Update status:- " + res.toString());
//        }
//
//        searchUser(phoneBook, PARTIAL_SEARCH.name(), FIRST_NAME.name(), "Abhi");
//        searchUser(phoneBook, PARTIAL_SEARCH.name(), LAST_NAME.name(), "new");
//        searchUser(phoneBook, PARTIAL_SEARCH.name(), LAST_NAME.name(), "mal");
//        searchUser(phoneBook, PARTIAL_SEARCH.name(), PHONE_NUMBER.name(), "722");
    }
}