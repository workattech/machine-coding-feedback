package main.java.module;

import java.util.HashMap;
import java.util.List;
public class TicTacToeBoard {
    int row;
    int col;
    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public char getBoard(int row, int col) {
        return board[row][col];
    }

    public void setBoard(int row, int col, char value) {
        this.board[row][col] = value;
    }

    char board[][];

    char[][] initboard(int row, int col){
        board = new char[row][col];
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                board[i][j] = '-';
            }
        }
        return board;
    }
}
