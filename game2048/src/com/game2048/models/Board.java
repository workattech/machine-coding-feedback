package com.game2048.models;

public class Board {
    private String[][] board;

    public Board(int boardRows, int boardColumns) {
        this.board = new String[boardRows][boardColumns];
        initialiseBoard(boardRows, boardColumns);
    }

    public String[][] getBoard() {
        return board;
    }

    public void setBoard(String[][] board) {
        this.board = board;
    }

    public void initialiseBoard(int boardRows, int boardColumns) {
        for (int i = 0; i < boardRows; i++) {
            for (int j = 0; j < boardColumns; j++) {
                board[i][j] = "-";
            }
        }
    }
}
