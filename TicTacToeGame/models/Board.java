package models;

public class Board {
    private int size;
    private char[][] boardState;
    public Board(int size) {
        this.size = size;
        this.boardState = new char[size+1][size+1];
        this.initializeBoardState();
    }

    public int getSize() {
        return this.size;
    }

    public char[][] getBoardState() {
        return this.boardState;
    }

    public void setSize(int size) {
        this.size = size;
        this.initializeBoardState();
    }

    private void initializeBoardState() {
        for(int row = 1; row <= this.size; row++) {
            for(int col = 1; col <= this.size; col++) {
                boardState[row][col] = '-';
            }
        }
    }

    public char getSymbolAt(int r, int c) {
        return this.boardState[r][c];
    }

    public void setPieceAt(int r, int c, char piece) {
        this.boardState[r][c] = piece;
    }

    public char getPieceAt(int r, int c) {
        return this.boardState[r][c];
    }
}
