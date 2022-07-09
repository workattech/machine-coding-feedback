package com.app.models;

public class Jump {
    private int startPosition;

    private int endPosition;

    int getStartPosition() {
        return startPosition;
    }

    int getEndPosition() {
        return endPosition;
    }


    public Jump(int startPosition, int endPosition) {
        this.startPosition = startPosition;
        this.endPosition = endPosition;
    }
}
