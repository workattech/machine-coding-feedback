package com.workAtTech.snakeAndLadderApp.model;

/*
 ** Problem Statement : Number of ladders (l) followed by l lines each containing 2 numbers denoting the start and end positions of the ladder.
 ** Rule 11: Each ladder will have its start position at some number and end position at a larger number.
 */
public class Ladder {
    private int start;
    private int end;

    public Ladder(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }
}
