package com.machine_coding.snakes_and_ladders.entities;

public class Player {

    private Integer id;
    private String name;
    private int position;
    private Integer boardId;

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public Player(Integer id, String name, Integer boardId) {
        this.id = id;
        this.name = name;
        this.boardId = boardId;
        this.position = 0;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}