package com.entities;

public class Ladder {
    private int start;
    private int end;

    public Ladder(int head,int tail){
        this.start=head;
        this.end=tail;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int head) {
        this.start = head;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int tail) {
        this.end = tail;
    }
}
