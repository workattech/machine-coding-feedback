package com.ticTacToe.model;

import java.util.Map;

public class TicTacToeGrid {
    private String[][] grid;

    public TicTacToeGrid(int gridRows, int gridCols) {
        this.grid = new String[gridRows][gridCols];
        initialiseGrid(gridRows - 1, gridCols - 1);
    }

    public void setGrid(String[][] grid) {
        this.grid = grid;
    }

    public String[][] getGrid() {
        return grid;
    }

    public void initialiseGrid(int gridRows, int gridCols) {
        for (int i = 1; i <= gridRows; i++) {
            for (int j = 1; j <= gridCols; j++) {
                grid[i][j] = "-";
            }
        }
    }
}