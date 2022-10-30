package test.java.PhoneBook.UpdateTest;

import main.java.PhoneBook.Model.SearchRequest;
import main.java.PhoneBook.Model.SearchResponse;
import main.java.PhoneBook.Model.User;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import test.java.PhoneBook.Base.Base;

import java.util.HashMap;

import static main.java.PhoneBook.Constant.Fields.FIRST_NAME;
import static main.java.PhoneBook.Constant.SearchType.COMPLETE_SEARCH;
import static main.java.PhoneBook.Constant.SearchType.PARTIAL_SEARCH;

public class UpdateUserFirstName extends Base {
  HashMap<String, User> users;

  @BeforeClass
  public void beforeClass(){
    users = new HashMap<>();
    for (User user : usersList) {
      Assert.assertEquals(Boolean.TRUE, phoneBook.add(user));
      users.put(user.getUserId(), user);
    }
    log("INFO User added count of users:- " + usersList.size());
  }

  @Test(testName = "Update user first name and complete search for updated field and old field")
  public void updateFirstNameVerifyByCompleteSearch(){
    log("Update user first name and complete search for updated field and old field");
    users.forEach( (userId, oldUser) -> {
      String newFirstName;
      // as names are created randomly there is still a chance they can collide
      do {
        newFirstName = utils.randomStringGen();
      }while(newFirstName.equals(oldUser.getFirstName()));

      User newUser = new User(oldUser.getUserId(), newFirstName, oldUser.getLastName(), oldUser.getPhoneNumber());
      users.put(userId, newUser);
      phoneBook.update(newUser);

      // check if new name is working
      SearchRequest searchRequest = new SearchRequest(COMPLETE_SEARCH.name(), FIRST_NAME.name(), newUser.getFirstName());
      SearchResponse searchResponse = phoneBook.search(searchRequest);
      Assert.assertTrue(utils.findInResponse(searchResponse, oldUser), "new field update on first name is not working");

      // check if old name is removed
      searchRequest = new SearchRequest(COMPLETE_SEARCH.name(), FIRST_NAME.name(), oldUser.getFirstName());
      searchResponse = phoneBook.search(searchRequest);
      Assert.assertFalse(utils.findInResponse(searchResponse, oldUser), "old field id not removed on first name");
    });
  }

  @Test(testName = "Update user first name and complete search for updated field and old field")
  public void updateFirstNameVerifyByPartialSearch(){
    log("Update user first name and complete search for updated field and old field");
    users.forEach( (userId, oldUser) -> {
      String newFirstName;
      // as names are created randomly there is still a chance they can collide
      do {
        newFirstName = utils.randomStringGen();
      }while(newFirstName.equals(oldUser.getFirstName()));

      User newUser = new User(oldUser.getUserId(), newFirstName, oldUser.getLastName(), oldUser.getPhoneNumber());
      users.put(userId, newUser);
      phoneBook.update(newUser);

      // check if new name is working
      SearchRequest searchRequest = new SearchRequest(PARTIAL_SEARCH.name(), FIRST_NAME.name(), utils.getRandomPrefix(newUser.getFirstName()));
      SearchResponse searchResponse = phoneBook.search(searchRequest);
      Assert.assertTrue(utils.findInResponse(searchResponse, newUser), "new field update on first name is not working");

      // check if old name is removed
      String oldRandomPrefix =  utils.getRandomPrefix(oldUser.getFirstName());
      searchRequest = new SearchRequest(PARTIAL_SEARCH.name(), FIRST_NAME.name(), oldRandomPrefix);
      searchResponse = phoneBook.search(searchRequest);

      // to avoid collision
      if(!(oldRandomPrefix.length() <= newFirstName.length() && newFirstName.toLowerCase().substring(0, oldRandomPrefix.length()).equals(oldRandomPrefix.toLowerCase())) ){
        boolean res = utils.findInResponse(searchResponse, oldUser);
        if(res) System.out.println( "Failed on :- " +  oldRandomPrefix + " " + newFirstName);
        Assert.assertFalse(utils.findInResponse(searchResponse, oldUser), "old field id not removed on first name");
      }
    });
  }
}

