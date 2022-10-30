package test.java.PhoneBook.UpdateTest;

import main.java.PhoneBook.Model.SearchRequest;
import main.java.PhoneBook.Model.SearchResponse;
import main.java.PhoneBook.Model.User;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import test.java.PhoneBook.Base.Base;

import java.util.HashMap;

import static main.java.PhoneBook.Constant.Fields.LAST_NAME;
import static main.java.PhoneBook.Constant.SearchType.COMPLETE_SEARCH;
import static main.java.PhoneBook.Constant.SearchType.PARTIAL_SEARCH;

public class UpdateUserLastNameTest extends Base {
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

  @Test(testName = "Update user last name and complete search for updated field and old field")
  public void updateLastNameVerifyByCompleteSearch(){
    log("Update user last name and complete search for updated field and old field");
    users.forEach( (userId, oldUser) -> {
      String newLastName;
      // as names are created randomly there is still a chance they can collide
      do {
        newLastName = utils.randomStringGen();
      }while(newLastName.equals(oldUser.getLastName()));

      User newUser = new User(oldUser.getUserId(), oldUser.getFirstName(), newLastName, oldUser.getPhoneNumber());
      users.put(userId, newUser);
      phoneBook.update(newUser);

      // check if new name is working
      SearchRequest searchRequest = new SearchRequest(COMPLETE_SEARCH.name(), LAST_NAME.name(), newUser.getLastName());
      SearchResponse searchResponse = phoneBook.search(searchRequest);
      Assert.assertTrue(utils.findInResponse(searchResponse, oldUser), "new field update on last name is not working");

      // check if old name is removed
      searchRequest = new SearchRequest(COMPLETE_SEARCH.name(), LAST_NAME.name(), oldUser.getLastName());
      searchResponse = phoneBook.search(searchRequest);
      Assert.assertFalse(utils.findInResponse(searchResponse, oldUser), "old field id not removed on last name");
    });
  }

  @Test(testName = "Update user last name and partial search for updated field and old field")
  public void updateLastNameVerifyByPartialSearch(){
    log("Update user last name and partial search for updated field and old field");
    users.forEach( (userId, oldUser) -> {
      String newLastName;
      // as names are created randomly there is still a chance they can collide
      do {
        newLastName = utils.randomStringGen();
      }while(newLastName.equals(oldUser.getLastName()));

      User newUser = new User(oldUser.getUserId(), oldUser.getFirstName(), newLastName, oldUser.getPhoneNumber());
      users.put(userId, newUser);
      phoneBook.update(newUser);

      // check if new name is working
      SearchRequest searchRequest = new SearchRequest(PARTIAL_SEARCH.name(), LAST_NAME.name(), utils.getRandomPrefix(newUser.getLastName()));
      SearchResponse searchResponse = phoneBook.search(searchRequest);
      Assert.assertTrue(utils.findInResponse(searchResponse, newUser), "new field update on last name is not working");

      // check if old name is removed
      String oldRandomPrefix =  utils.getRandomPrefix(oldUser.getLastName());
      searchRequest = new SearchRequest(PARTIAL_SEARCH.name(), LAST_NAME.name(), oldRandomPrefix);
      searchResponse = phoneBook.search(searchRequest);

      // to avoid collision
      if(!(oldRandomPrefix.length() <= newLastName.length() && newLastName.toLowerCase().substring(0, oldRandomPrefix.length()).equals(oldRandomPrefix.toLowerCase())) ){
        boolean res = utils.findInResponse(searchResponse, oldUser);
        if(res) System.out.println( "Failed on :- " +  oldRandomPrefix + " " + newLastName);
        Assert.assertFalse(utils.findInResponse(searchResponse, oldUser), "old field id not removed on last name");
      }
    });
  }
}
