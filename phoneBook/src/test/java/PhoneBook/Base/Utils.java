package test.java.PhoneBook.Base;

import main.java.PhoneBook.Model.SearchResponse;
import main.java.PhoneBook.Model.User;

public class Utils {

  public String randomStringGen(){
    int maxLen = 12, minLen = 8;
    int len = (int)(Math.random()*(maxLen-minLen+1)+minLen);
    String res = "";
    String randomString = "abcdefgABCDEFG";
    for(int i = 0 ; i < len ; ++i){
      int idx = (int)(Math.random()*randomString.length());
      res += randomString.charAt(idx);
    }
    return  res;
  }

  public String randomNumberGen(){
    int len = 10;
    String res = "";
    for(int i = 0 ; i < len ; ++i){
      int x = (int)(Math.random()*10);
      char c = (char)(x + '0');
      res += c;
    }
    return  res;
  }

  public User randomUserGen(){
    String firstName = randomStringGen();
    String lastName = randomStringGen();
    String phoneNumber = randomNumberGen();
    return new User(firstName, lastName, phoneNumber);
  }

  public boolean findInResponse(SearchResponse searchResponse, User toFind){
    for(User user : searchResponse.getUsers() ){
      if(toFind.getUserId().equals(user.getUserId()))
        return true;
    }
    return false;
  }

  public String getRandomPrefix(String s){
    int end = (int) (Math.random()*(s.length() - 3 + 1) + 3);
    return s.substring(0, end);
  }

}
