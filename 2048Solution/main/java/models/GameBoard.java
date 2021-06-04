package main.java.models;

import java.util.ArrayList;
import java.util.List;

public class GameBoard {


    private int size;
    private int[][] board;
    private int rowToBeFilled;
    private int columnToBeFilled;
    private List<Integer> getRandomFrom = new ArrayList<>();

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getRowToBeFilled() {
        return rowToBeFilled;
    }

    public void setRowToBeFilled(int rowToBeFilled) {
        this.rowToBeFilled = rowToBeFilled;
    }

    public int getColumnToBeFilled() {
        return columnToBeFilled;
    }

    public void setColumnToBeFilled(int columnToBeFilled) {
        this.columnToBeFilled = columnToBeFilled;
    }


    public List<Integer> getGetRandomFrom() {

        return this.getRandomFrom;
    }

    public void resetGetRandomFrom() {
        this.getRandomFrom.clear();
        int number = 1;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (getValueInBoard(i, j) == 0) {
                    this.getRandomFrom.add(number);
                }
                number++;
            }
        }
    }

    void initializeBoard(int size) {
        board = new int[size][size];
        resetGetRandomFrom();
    }

    void setValueInBoard(int rowNum, int columnNum, int value) {
        board[rowNum][columnNum] = value;
    }

    int getValueInBoard(int rowNum, int columnNum) {
        return board[rowNum][columnNum];
    }
}
