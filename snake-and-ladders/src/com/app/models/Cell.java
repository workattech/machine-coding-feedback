package com.app.models;

public class Cell {
    private int number;
    private int endPosition;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    int getEndPosition() {
        return endPosition;
    }

    public void setEndPosition(int endPosition) {
        this.endPosition = endPosition;
    }


    Cell(int number, int endPosition) {
        this.number = number;
        this.endPosition = endPosition;
    }

}
