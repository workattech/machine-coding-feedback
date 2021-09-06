package com.gaurparas;

public class Ladder implements IJump {
    private int start;
    private int end;

    public Ladder(int start, int end) {
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
