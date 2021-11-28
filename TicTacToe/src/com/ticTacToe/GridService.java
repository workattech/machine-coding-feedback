package com.ticTacToe;

import com.ticTacToe.model.Player;
import com.ticTacToe.model.TicTacToeGrid;

import java.util.List;

public class GridService {
    private String[][] grid;
    private int gridRows;
    private int gridCols;
    private int totalMovesCount = 0;
    TicTacToeGrid ticTacToeGrid;

    public GridService(int gridRows, int gridCols) {
        this.gridRows = gridRows;
        this.gridCols = gridCols;
        ticTacToeGrid = new TicTacToeGrid(gridRows + 1, gridCols + 1); //grid index starts from 1-3 hence needs size+1
        this.grid = ticTacToeGrid.getGrid();
        System.out.println();
        printGrid(gridRows, gridCols);
    }

    public void printGrid(int gridRows, int gridCols) {
        for (int i = 1; i <= this.gridRows; i++) {
            for (int j = 1; j <= this.gridCols; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }

    public boolean isGameOver(int defaultMaxMoves) {
        if (totalMovesCount == defaultMaxMoves) {
            return true;
        }
        return false;
    }

    public boolean isMakeMovePossible(int gridRows, int gridCols, String piece) { // check if move is invalid then same player will play again
        if (isValidMove(gridRows, gridCols)) {
            grid[gridRows][gridCols] = piece; // Requirement : put the piece on the cell
            printGrid(gridRows, gridCols); // Requirement : print the board after the move
            totalMovesCount++;
            return true;
        } else {
            System.out.println("Invalid Move"); // Requirement : print 'Invalid Move'
            return false;
        }
    }

    private boolean isValidMove(int gridRows, int gridCols) {
        //Requirement : The piece is controlled by the player having the current turn
        if (gridRows > this.gridRows || gridRows < 1) {
            return false;
        }
        if (gridCols > this.gridCols || gridCols < 1) {
            return false;
        }
        return grid[gridRows][gridCols].equals("-"); // Requirement : The cell is empty
    }

    public boolean isPlayerWinner(String piece) {
        return (isPieceRowWinner(piece) || isPieceColumnWinner(piece) || isPieceLeftDiagonalWinner(piece) || isPieceRightDiagonalWinner(piece));
    }

    private boolean isPieceRightDiagonalWinner(String piece) {
        for (int i = 1, j = gridCols; i <= gridRows && j >= 1; i++, j--) {
            if (!grid[i][j].equals(piece)) {
                return false;
            }
        }
        return true;
    }

    private boolean isPieceLeftDiagonalWinner(String piece) {
        for (int i = 1, j = 1; i <= gridRows && j <= gridCols; i++, j++) {
            if (!grid[i][j].equals(piece)) {
                return false;
            }
        }
        return true;
    }

    private boolean isPieceColumnWinner(String piece) {
        for (int i = 1; i <= gridCols; i++) {
            boolean colWinFlag = true;
            for (int j = 1; j <= gridRows; j++) {
                if (!grid[j][i].equals(piece)) {
                    colWinFlag = false;
                    break;
                }
            }
            if (colWinFlag) return true;
        }
        return false;
    }

    private boolean isPieceRowWinner(String piece) {
        for (int i = 1; i <= gridRows; i++) {
            boolean rowWinFlag = true;
            for (int j = 1; j <= gridCols; j++) {
                if (!grid[i][j].equals(piece)) {
                    rowWinFlag = false;
                    break;
                }
            }
            if (rowWinFlag) return true;
        }
        return false;
    }
}
