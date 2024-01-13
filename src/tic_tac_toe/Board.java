package src.tic_tac_toe;

public class Board {
    private int size;
    private char[][] grid;
    private boolean gameStarted;

    public Board(int size) {
        this.size = size;
        grid = new char[size][size];
        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j) {
                grid[i][j] = '-';
            }
        }
        this.gameStarted = false;
    }

    public void printBoard() {
        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.print("\n");
        }
        System.out.print("\n");
    }

    private boolean isRowSame() {
        if (!gameStarted) {
            return false;
        }
        for (int i = 0; i < size; ++i) {
            boolean value = true;
            for (int j = 0; j < size; ++j) {
                if (grid[i][0] != grid[i][j] || grid[i][j] == '-') {
                    value = false;
                    break;
                }
            }
            if (value) {
                return true;
            }
        }
        return false;
    }

    private boolean isColoumnSame() {
        if (!gameStarted) {
            return false;
        }
        for (int j = 0; j < size; ++j) {
            boolean value = true;
            for (int i = 0; i < size; ++i) {
                if (grid[0][j] != grid[i][j] || grid[i][j] == '-') {
                    value = false;
                    break;
                }
            }
            if (value) {
                return true;
            }
        }
        return false;
    }

    private boolean isDiagonalSame() {
        if (!gameStarted) {
            return false;
        }
        boolean valueDiagonal = true, valueOppositeDiagonal = true;
        for (int i = 0; i < size; ++i) {
            if (grid[0][0] != grid[i][i] || grid[i][i] == '-') {
                valueDiagonal = false;
            }
            if (grid[0][size - 1] != grid[i][size - 1 - i] || grid[i][size - 1 - i] == '-') {
                valueOppositeDiagonal = false;
            }
        }
        if (valueDiagonal || valueOppositeDiagonal) {
            return true;
        }
        return false;
    }

    public boolean isBoardSolved() {
        return isRowSame() || isColoumnSame() || isDiagonalSame();
    }

    public boolean isGameOver() {
        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j) {
                if (grid[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean playChance(int i, int j, Player p) {
        i--;
        j--;
        if (i < 0 || i > size || j < 0 || j > size || grid[i][j] != '-') {
            return false;
        }
        gameStarted = true;
        // System.out.println(i + " " + j + " " + p.getPiece());
        grid[i][j] = p.getPiece();
        printBoard();
        return true;
    }
}
