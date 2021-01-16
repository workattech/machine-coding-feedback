package com.machine_coding.snakes_and_ladders.entities;

public class Ladder extends Entity {

    private int top;
    private int down;
    private Integer boardId;

    public Ladder(Integer id, Integer top, Integer down, Integer boardId) {
        super(id);
        this.top = top;
        this.down = down;
        this.boardId = boardId;
    }

    public Integer getTop() {
        return top;
    }

    public void setTop(Integer top) {
        this.top = top;
    }

    public Integer getDown() {
        return down;
    }

    public void setDown(Integer down) {
        this.down = down;
    }
}