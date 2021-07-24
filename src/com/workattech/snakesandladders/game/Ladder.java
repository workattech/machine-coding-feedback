package com.workattech.snakesandladders.game;

public class Ladder {

    private int ladderHead;
    private int ladderSnake;

    public Ladder(int ladderHead, int ladderSnake) {
        this.ladderHead = ladderHead;
        this.ladderSnake = ladderSnake;
    }

    public int getLadderHead() {
        return ladderHead;
    }

    public int getLadderSnake() {
        return ladderSnake;
    }
}
