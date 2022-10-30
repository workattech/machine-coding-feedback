package test.java.PhoneBook.SearchTest;

import main.java.PhoneBook.Model.SearchRequest;
import main.java.PhoneBook.Model.SearchResponse;
import main.java.PhoneBook.Model.User;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import test.java.PhoneBook.Base.Base;

import static main.java.PhoneBook.Constant.Fields.FIRST_NAME;
import static main.java.PhoneBook.Constant.SearchType.COMPLETE_SEARCH;
import static main.java.PhoneBook.Constant.SearchType.PARTIAL_SEARCH;

public class SearchUserByFirstName extends Base {

  @BeforeClass
  public void beforeClass(){
    for (User user : usersList)
      Assert.assertEquals(Boolean.TRUE, phoneBook.add(user));
    log("User added count of users:- " + usersList.size());
  }

  @Test(testName = "Search for user by first name search type complete search")
  public void searchComplete() {
    log("Searching for user first name in phone. Search type COMPLETE");
    for(User user : usersList){
      SearchRequest searchRequest = new SearchRequest(COMPLETE_SEARCH.name(), FIRST_NAME.name(), user.getFirstName());
      SearchResponse searchResponse = phoneBook.search(searchRequest);
      Assert.assertEquals(true, utils.findInResponse(searchResponse, user));
    }
  }
  @Test(testName = "Search for user by first name search type partial search")
  public void searchPartial() {
    log("Searching for user first name in phone. Search type PARTIAL");
    for(User user : usersList){
      SearchRequest searchRequest = new SearchRequest(PARTIAL_SEARCH.name(), FIRST_NAME.name(), utils.getRandomPrefix(user.getFirstName()));
      SearchResponse searchResponse = phoneBook.search(searchRequest);
      Assert.assertEquals(true, utils.findInResponse(searchResponse, user));
    }
  }
}
