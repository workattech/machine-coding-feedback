package com.game2048;

import com.game2048.models.Board;

import java.util.Random;

public class BoardService {
    private int boardRows;
    private int boardColumns;
    Board boardInstance;
    String[][] board;
    TileService tileService;

    public BoardService(int boardRows, int boardColumns) {
        this.boardRows = boardRows;
        this.boardColumns = boardColumns;
        boardInstance = new Board(boardRows, boardColumns);
        board = boardInstance.getBoard();
        tileService = new TileService();
    }

    public int getBoardRows() {
        return boardRows;
    }

    public void setBoardRows(int boardRows) {
        this.boardRows = boardRows;
    }

    public int getBoardColumns() {
        return boardColumns;
    }

    public void setBoardColumns(int boardColumns) {
        this.boardColumns = boardColumns;
    }

    public void printBoard() {
        for (int i = 0; i < this.boardRows; i++) {
            for (int j = 0; j < this.boardColumns; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public int randomBoardIndexGenerator(int value) {
        return new Random().nextInt(value) + 1; // generate random value from 1 to value
    }

    public void randomTileInsertor(String flagSetTwo) {
        boolean isRandomFileInserted = false;
        while (!isRandomFileInserted) {
            int randomBoardRow = randomBoardIndexGenerator(boardRows);
            int randomBoardColumn = randomBoardIndexGenerator(boardColumns);
            if (board[randomBoardRow - 1][randomBoardColumn - 1].equals("-")) {
                if(flagSetTwo.equals("2")) {
                    board[randomBoardRow - 1][randomBoardColumn - 1] = "2";
                }else {
                    board[randomBoardRow - 1][randomBoardColumn - 1] = tileService.tile.getTile(); // tileService will give any random string in power of two
                }
                isRandomFileInserted = true;
            }
        }
    }

    public boolean isGameWon(int winningValue) {
        for (int i = 0; i < boardRows; i++) {
            for (int j = 0; j < boardColumns; j++) {
                if (board[i][j].equals("" + winningValue)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isGameOver() {
        for (int i = 0; i < boardRows; i++) {
            for (int j = 0; j < boardColumns; j++) {
                if (board[i][j].equals("-")) {
                    return false;
                }
            }
        }
        return true;
    }

    // slideTilesTopDirection() will remove spaces in top direction if it is any and then slide tiles in top direction
    public void slideTilesInTopDirection() {
        for (int i = 0; i < boardColumns; i++) {
            int k = 0, j = 0;
            while (j < boardRows) {
                if (!board[j][i].equals("-")) {
                    board[k][i] = board[j][i];
                    if (k != j) {
                        board[j][i] = "-";
                    }
                    k++;
                    j++;
                } else {
                    j++;
                }
            }
        }
    }

    public void mergeTilesInTopDirection() {
        for (int i = 0; i < boardColumns; i++) {
            for (int j = 0; j < boardRows - 1; j++) {
                if (board[j][i].equals(board[j + 1][i]) && !board[j][i].equals("-")) {
                    board[j][i] = "" + 2 * Integer.parseInt(board[j][i]);
                    board[j + 1][i] = "-";
                }
            }
        }
    }

    public void slideTilesInBottomDirection() {
        for (int i = 0; i < boardColumns; i++) {
            int k = boardRows - 1, j = boardRows - 1;
            while (j >= 0) {
                if (!board[j][i].equals("-")) {
                    board[k][i] = board[j][i];
                    if (k != j) board[j][i] = "-";
                    k--;
                    j--;
                } else {
                    j--;
                }
            }
        }
    }

    public void mergeTilesInBottomDirection() {
        for (int i = 0; i < boardColumns; i++) {
            for (int j = boardRows - 1; j > 0; j--) {
                if (board[j][i].equals(board[j - 1][i]) && !board[j][i].equals("-")) {
                    board[j][i] = "" + 2 * Integer.parseInt(board[j][i]);
                    board[j - 1][i] = "-";
                }
            }
        }
    }

    public void slidTilesInRightDirection() {
        for (int i = 0; i < boardRows; i++) {
            int k = boardColumns - 1, j = boardColumns - 1;
            while (j >= 0) {
                if (!board[i][j].equals("-")) {
                    board[i][k] = board[i][j];
                    if (k != j) board[i][j] = "-";
                    k--;
                    j--;
                } else {
                    j--;
                }
            }
        }

    }

    public void mergeTilesInRightDirection() {
        for (int i = 0; i < boardRows; i++) {
            for (int j = boardColumns - 1; j > 0; j--) {
                if (board[i][j].equals(board[i][j - 1]) && !board[i][j].equals("-")) {
                    board[i][j] = "" + 2 * Integer.parseInt(board[i][j]);
                    board[i][j - 1] = "-";
                }
            }
        }
    }

    public void slidTilesInLeftDirection() {
        for (int i = 0; i < boardRows; i++) {
            int k = 0, j = 0;
            while (j < boardColumns) {
                if (!board[i][j].equals("-")) {
                    board[i][k] = board[i][j];
                    if (k != j) board[i][j] = "-";
                    k++;
                    j++;
                } else {
                    j++;
                }
            }
        }
    }

    public void mergeTilesinLeftDirection() {
        for (int i = 0; i < boardRows; i++) {
            for (int j = 0; j < boardColumns - 1; j++) {
                if (board[i][j].equals(board[i][j + 1]) && !board[i][j].equals("-")) {
                    board[i][j] = "" + 2 * Integer.parseInt(board[i][j]);
                    board[i][j + 1] = "-";
                }
            }
        }
    }
}
