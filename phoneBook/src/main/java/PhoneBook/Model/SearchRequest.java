package main.java.PhoneBook.Model;

import main.java.PhoneBook.Constant.Fields;
import main.java.PhoneBook.Constant.SearchType;

public class SearchRequest {
    String searchType;
    String searchField;
    String query;

    public SearchRequest(String searchType, String searchField, String query) {
        // Check if searchRequest is valid
        Fields.valueOf(searchField);
        SearchType.valueOf(searchType);
        this.searchType = searchType;
        this.searchField = searchField;
        this.query = query;
    }

    public String getSearchType() {
        return searchType;
    }

    public String getQuery() {
        return query;
    }

    public String getSearchField() {
        return searchField;
    }

}
