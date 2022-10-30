package test.java.PhoneBook.SearchTest;

import main.java.PhoneBook.Model.SearchRequest;
import main.java.PhoneBook.Model.SearchResponse;
import main.java.PhoneBook.Model.User;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import test.java.PhoneBook.Base;

import static main.java.PhoneBook.Constant.Fields.PHONE_NUMBER;
import static main.java.PhoneBook.Constant.SearchType.COMPLETE_SEARCH;
import static main.java.PhoneBook.Constant.SearchType.PARTIAL_SEARCH;

public class SearchUserByPhoneNumber extends Base {
  @BeforeClass
  public void beforeClass(){
    for (User user : usersList)
      Assert.assertEquals(Boolean.TRUE, phoneBook.add(user));
    System.out.println("INFO User added count of users:- " + usersList.size());
  }

  @Test(testName = "Search for user by phone number search type complete search")
  public void searchComplete() {
    for(User user : usersList){
      SearchRequest searchRequest = new SearchRequest(COMPLETE_SEARCH.name(), PHONE_NUMBER.name(), user.getPhoneNumber());
      SearchResponse searchResponse = phoneBook.search(searchRequest);
      Assert.assertEquals(true, utils.findInResponse(searchResponse, user));
    }
  }
  @Test(testName = "Search for user by phone number search type partial search")
  public void searchPartial() {
    for(User user : usersList){
      SearchRequest searchRequest = new SearchRequest(PARTIAL_SEARCH.name(), PHONE_NUMBER.name(), utils.getRandomPrefix(user.getPhoneNumber()));
      SearchResponse searchResponse = phoneBook.search(searchRequest);
      Assert.assertEquals(true, utils.findInResponse(searchResponse, user));
    }
  }
}
