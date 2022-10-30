package test.java.PhoneBook.Base;

import main.java.PhoneBook.Model.User;
import main.java.PhoneBook.PhoneBook;

import java.util.ArrayList;
import java.util.List;

public class Base {
  public PhoneBook phoneBook;
  public List<User> usersList;
  public Utils utils;


  public Base(){
    this.phoneBook = new PhoneBook();
    this.usersList = new ArrayList<>();
    this.utils = new Utils();
    int userCount = 1000;
    for(int i = 0 ; i < userCount ; ++i)
      usersList.add(utils.randomUserGen());
  }

  public void log(String message){
    System.out.println("INFO :- " + message);
  }

}
