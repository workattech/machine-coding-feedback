package com.workattech.snakesandladders.game;

public class Ladder {

    private int ladderHead;
    private int ladderTail;

    public Ladder(int ladderHead, int ladderTail) {
        this.ladderHead = ladderHead;
        this.ladderTail = ladderTail;
    }

    public int getLadderHead() {
        return ladderHead;
    }

    public int getLadderTail() {
        return ladderTail;
    }
}
