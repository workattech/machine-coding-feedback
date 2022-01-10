package com.hitesh.demo.snakeladder.entity;

import lombok.Getter;

@Getter
public class Move{

    private String id;
    private CellPosition start;
    private CellPosition end;
    private Player playedBy;

    public Move(String id, Player playedBy) {
        this.id = id;
        this.playedBy = playedBy;
    }

    public void move(CellPosition start, CellPosition end){
        this.start = start;
        this.end = end;
    };
}
