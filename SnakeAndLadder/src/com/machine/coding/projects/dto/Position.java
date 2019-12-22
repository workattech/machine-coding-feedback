package com.machine.coding.projects.dto;

public class Position {

    private int start;

    private int end;

    public Position(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    @Override
    public String toString() {
        return "Position{" +
               "start=" + start +
               ", end=" + end +
               '}';
    }
}
