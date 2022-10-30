package test.java.PhoneBook.UpdateTest;

import main.java.PhoneBook.Model.SearchRequest;
import main.java.PhoneBook.Model.SearchResponse;
import main.java.PhoneBook.Model.User;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import test.java.PhoneBook.Base;

import java.util.HashMap;

import static main.java.PhoneBook.Constant.Fields.FIRST_NAME;
import static main.java.PhoneBook.Constant.Fields.PHONE_NUMBER;
import static main.java.PhoneBook.Constant.SearchType.COMPLETE_SEARCH;
import static main.java.PhoneBook.Constant.SearchType.PARTIAL_SEARCH;



public class UpdateUserPhoneNumber extends Base {
  HashMap<String, User> users;

  @BeforeClass
  public void beforeClass(){
    users = new HashMap<>();
    for (User user : usersList) {
      Assert.assertEquals(Boolean.TRUE, phoneBook.add(user));
      users.put(user.getUserId(), user);
    }
    System.out.println("INFO User added count of users:- " + usersList.size());
  }

  @Test
  public void updateFirstNameVerifyByCompleteSearch(){
    users.forEach( (userId, oldUser) -> {
      String newPhoneNumber;
      // as names are created randomly there is still a chance they can collide
      do {
        newPhoneNumber = utils.randomNumberGen();
      }while(newPhoneNumber.equals(oldUser.getPhoneNumber()));

      User newUser = new User(oldUser.getUserId(), oldUser.getFirstName(), oldUser.getLastName(), newPhoneNumber);
      users.put(userId, newUser);
      phoneBook.update(newUser);

      // check if new name is working
      SearchRequest searchRequest = new SearchRequest(COMPLETE_SEARCH.name(), PHONE_NUMBER.name(), newUser.getPhoneNumber());
      SearchResponse searchResponse = phoneBook.search(searchRequest);
      Assert.assertTrue(utils.findInResponse(searchResponse, oldUser), "new field update on phone number is not working");

      // check if old name is removed
      searchRequest = new SearchRequest(COMPLETE_SEARCH.name(), PHONE_NUMBER.name(), oldUser.getPhoneNumber());
      searchResponse = phoneBook.search(searchRequest);
      Assert.assertFalse(utils.findInResponse(searchResponse, oldUser), "old field id not removed on phone number");
    });
  }

  @Test
  public void updateFirstNameVerifyByPartialSearch(){
    users.forEach( (userId, oldUser) -> {
      String newPhoneNumber;
      // as names are created randomly there is still a chance they can collide
      do {
        newPhoneNumber = utils.randomNumberGen();
      }while(newPhoneNumber.equals(oldUser.getPhoneNumber()));

      User newUser = new User(oldUser.getUserId(), oldUser.getFirstName(), oldUser.getLastName(), newPhoneNumber);
      users.put(userId, newUser);
      phoneBook.update(newUser);

      // check if new name is working
      SearchRequest searchRequest = new SearchRequest(PARTIAL_SEARCH.name(), PHONE_NUMBER.name(), newUser.getPhoneNumber());
      SearchResponse searchResponse = phoneBook.search(searchRequest);
      Assert.assertTrue(utils.findInResponse(searchResponse, oldUser), "new field update on phone number is not working");

      // check if old name is removed
      String oldRandomPrefix =  utils.getRandomPrefix(oldUser.getPhoneNumber());
      searchRequest = new SearchRequest(PARTIAL_SEARCH.name(), PHONE_NUMBER.name(), oldRandomPrefix);
      searchResponse = phoneBook.search(searchRequest);

      // to avoid collision
      if(!newPhoneNumber.substring(0, oldRandomPrefix.length()).equals(oldRandomPrefix)){
        boolean res = utils.findInResponse(searchResponse, oldUser);
        if(res) System.out.println( "Failed on :- " +  oldRandomPrefix + " " + newPhoneNumber);
        Assert.assertFalse(utils.findInResponse(searchResponse, oldUser), "old field id not removed on phone number");
      }
    });
  }
}