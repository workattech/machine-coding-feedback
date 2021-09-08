package com.workAtTech.snakeAndLadderApp.model;

/*
 ** Problem statement : Number of players (p) followed by p lines each containing a name.
 ** name can be duplicate , to make it unique we can use ID , ID can be combination of name and int so make id as a string
 ** Number of player is input from Scanner class
 ** Player class will contain name and position as a data
 */
public class Player {
    private String name;
    private String id;

    public Player(String name) {
        this.name = name;
        //this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }
}
