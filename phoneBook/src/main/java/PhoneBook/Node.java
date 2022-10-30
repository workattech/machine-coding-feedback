package main.java.PhoneBook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import static main.java.PhoneBook.Constant.SearchType.COMPLETE_SEARCH;
import static main.java.PhoneBook.Constant.SearchType.PARTIAL_SEARCH;

public class Node {

    HashMap<Character, Node> children;
    HashSet<String> userIdsPartial;
    HashSet<String> userIdsComplete;

    Node(){
        children = new HashMap<>();
        userIdsPartial = new HashSet<>();
        userIdsComplete = new HashSet<>();
    }

    public boolean add(String userId, String fieldValue){
        Node node = this;
        String parameter = fieldValue.toLowerCase();
        for(int i = 0 ; i < parameter.length() ; ++i){
            char c = parameter.charAt(i);
            if(!node.children.containsKey(c))
                node.children.put(c, new Node());
            node = node.children.get(c);
            node.userIdsPartial.add(userId);
        }
        node.userIdsComplete.add(userId);
        return true;
    }

    public boolean update(String userId, String fieldValueOld, String fieldValueNew){
        if(fieldValueNew.equals(fieldValueOld))
            return true;
        Node node = this;
        String oldParameter = fieldValueOld.toLowerCase();
        String newParameter = fieldValueNew.toLowerCase();
        for(int i = 0 ; i < oldParameter.length() ; ++i){
            char c = oldParameter.charAt(i);
            if(!node.children.containsKey(c))
                return false;
            node = node.children.get(c);
            if(!node.userIdsPartial.contains(userId))
                return false;
            node.userIdsPartial.remove(userId);
        }
        if(!node.userIdsComplete.contains(userId))
            return false;
        node.userIdsComplete.remove(userId);
        return add(userId, fieldValueNew);
    }

    public List<String> search(String searchType, String query){
        query = query.toLowerCase();
        Node node = this;
        for(int i = 0 ; i < query.length() ; ++i){
            char c = query.charAt(i);
            if(node.children.containsKey(c) == false)
                return new ArrayList<>();
            node = node.children.get(c);
        }
        if(searchType == COMPLETE_SEARCH.name())
            return node.userIdsComplete.stream().toList();
        else if(searchType == PARTIAL_SEARCH.name())
            return node.userIdsPartial.stream().toList();
        return new ArrayList<>();
    }


    void print(String fieldValue){
        System.out.println( "Count of partial user:- " +  this.userIdsPartial.size() + " " + fieldValue);
        userIdsPartial.forEach(uId ->{
            System.out.println("Partial user id is:- " + uId);
        });
        System.out.println( "Count of complete user:- " +  this.userIdsComplete.size() + " " + fieldValue);
        userIdsComplete.forEach(uId ->{
            System.out.println("Partial user id is:- " + uId);
        });
        System.out.println("--------");
    }

}
