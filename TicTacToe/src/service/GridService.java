package service;

import exception.InvalidMove;
import model.Grid;
import model.Player;

import java.util.Arrays;

public class GridService {
    private Grid grid;

    public Grid initializeGrid(int rows, int cols, Player[] players) {
        grid = new Grid(rows, cols, players);
        for (char[] row : grid.getGrid()) {
            Arrays.fill(row, '_');
        }
        printGrid();
        return grid;
    }

    public boolean makeAMove(int row, int col) {
        char[][] board = grid.getGrid();
        if (row > grid.getNumberOfRows() || col > grid.getNumberOfColumns() || board[row-1][col-1] != '_') {
            throw new InvalidMove("Invalid Move");
        }

        board[row-1][col-1] = grid.getCurrentPlayer() == 0 ? 'X' : 'O';
        printGrid();
        boolean isValid = isComplete(board, board[row-1][col-1]);
        if (isValid) {
            String name = grid.getCurrentPlayer() == 0 ? grid.getPlayers()[0].getName() : grid.getPlayers()[1].getName();
            System.out.println(name + " won the game");
        }
        grid.setCurrentPlayer((grid.getCurrentPlayer()+1) % grid.getNumberOfPlayers());
        return isValid;
    }

    public boolean isComplete(char[][] board, char currentToken) {
        int rows = grid.getNumberOfRows();
        int cols = grid.getNumberOfColumns();
        boolean isValid = true;

        for (int row=0; row<rows; row++) {
            for (int col=0; col<cols; col++) {
                if (board[row][col] != currentToken) {
                    isValid = false;
                    break;
                }
            }
            if (isValid) return true;
        }

        isValid = true;
        for (int col=0; col<cols; col++) {
            for (int row=0; row<rows; row++) {
                if (board[row][col] != currentToken) {
                    isValid = false;
                    break;
                }
            }
            if (isValid) return true;
        }

        isValid = true;
        for (int i=0; i<rows; i++) {
            if (board[i][i] != currentToken) {
                isValid = false;
                break;
            }
        }

        return isValid;

    }

    private void printGrid() {
        int row = grid.getNumberOfRows();
        int col = grid.getNumberOfColumns();

        for (int r=0; r<row; r++) {
            for (int c=0; c<col; c++) {
                System.out.print(grid.getGrid()[r][c] + " ");
            }
            System.out.println();
        }
    }

    @Override
    public String toString() {
        return "GridService{" +
                "grid=" + grid +
                '}';
    }
}
