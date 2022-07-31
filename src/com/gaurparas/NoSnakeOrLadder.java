package com.gaurparas;

public class NoSnakeOrLadder implements IJump{
    private int start;
    private int end;

    public NoSnakeOrLadder(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int jumpTo() {
        return this.end;
    }
}
