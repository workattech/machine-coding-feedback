package main.java.PhoneBook;

import main.java.DB.InMemoryUserDB;
import main.java.PhoneBook.Constant.Fields;
import main.java.PhoneBook.Model.SearchRequest;
import main.java.PhoneBook.Model.SearchResponse;
import main.java.PhoneBook.Model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PhoneBook implements PhoneBookInterface {
    HashMap<Fields, Node> fields;
    InMemoryUserDB DB;

    public PhoneBook() {
        DB = new InMemoryUserDB();
        fields = new HashMap<>();
        for(Fields field : Fields.values())
            fields.put(field, new Node());
    }
    // main.java.DB and nodes are not connected;
    @Override
    public Boolean add(User user) {
        if(DB.add(user)){
            for(Fields field : Fields.values())
                fields.get(field).add(user.getUserId(), user.getField(field));
            return true;
        }
        return false;
    }

    // main.java.DB and nodes are not connected;
    @Override
    public Boolean update(User user) {
        if(!DB.contains(user))
            return false;
        User oldUser = DB.get(user.getUserId());
        if(DB.update(user)){
            for(Fields field : Fields.values())
                fields.get(field).update(user.getUserId(), oldUser.getField(field), user.getField(field));
            return true;
        }
        return false;
    }

    @Override
    public SearchResponse search(SearchRequest searchRequest) {
        Fields field = Fields.valueOf(searchRequest.getSearchField());
        Node searchedField = fields.get(field);
        List<String> userIds = searchedField.search(searchRequest.getSearchType(), searchRequest.getQuery());
        List<User> users = new ArrayList<>();
        userIds.forEach(userId -> users.add(DB.get(userId)));
        return new SearchResponse(users);
    }
}
