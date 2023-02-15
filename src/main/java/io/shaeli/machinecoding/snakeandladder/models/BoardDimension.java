package io.shaeli.machinecoding.snakeandladder.models;

public class BoardDimension {
    private int row;
    private int col;

    public BoardDimension(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return this.row;
    }

    public int getCol() {
        return this.col;
    }
}
