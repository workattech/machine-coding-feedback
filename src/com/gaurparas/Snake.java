package com.gaurparas;

public class Snake implements IJump{
    private int start;
    private int end;

    public Snake(int start, int end) {
        this.start = start;
        this.end = end;
    }

    /*@Override
    public boolean isPresent(int position) {
        return this.start == position;
    }*/

    @Override
    public int jumpTo() {
        return this.end;
    }
}
