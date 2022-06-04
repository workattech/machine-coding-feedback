package com.workattech.snakesandladders.game;

public class Board {

    private int size;
    private int startBoardIndex;
    private int endBoardIndex;

    public Board(int size) {
        this.size = size;
        this.startBoardIndex = 1;
        this.endBoardIndex = startBoardIndex + size - 1;
    }

    public int getSize() {
        return size;
    }

    public int getStartBoardIndex() {
        return startBoardIndex;
    }

    public int getEndBoardIndex() {
        return endBoardIndex;
    }
}
