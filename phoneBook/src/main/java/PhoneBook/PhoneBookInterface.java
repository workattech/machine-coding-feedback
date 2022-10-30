package main.java.PhoneBook;

import main.java.PhoneBook.Model.SearchRequest;
import main.java.PhoneBook.Model.SearchResponse;
import main.java.PhoneBook.Model.User;

public interface PhoneBookInterface {
    Boolean add(User user);
    Boolean update(User user);
    SearchResponse search(SearchRequest searchRequest);
}
