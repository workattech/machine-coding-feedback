package org.example.models;

import java.util.HashMap;

public class User {
    public Integer uid, mobNo; // not implementing getter and setter for now
    public String name, email; // not implementing getter and setter for now

    public HashMap<Integer, Integer> dues; // HashMap< UserID , Amount Due >

    public void recordTransaction (User toUser, int amount) {
        if(dues.containsKey(toUser.uid)){
            dues.put(toUser.uid, dues.get(toUser.uid) + amount);
        }
        else dues.put(toUser.uid, amount);
    }

    @Override
    public String toString(){
        return uid.toString() + " " + dues.toString();
    }

}