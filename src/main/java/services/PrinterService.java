package services;

import model.Board;
import model.Piece;

public class PrinterService {
    private Board board;

    public PrinterService(Board board) {
        this.board = board;
    }

    public void printBoard() {
        String boardLayout[][] = new String[9][9];
        for (int i = 1; i <= 8; i++) {
            for (int j = 1; j <= 8; j++) {
                boardLayout[i][j] = "--";
            }
        }
        for (Piece piece : board.getWhitePieces()) {
            int position = piece.getCurrentPos();
            int row = position / 10;
            int col = position % 10;
            String symbol = piece.getSymbol();
            boardLayout[row][col] = symbol;
        }
        for (Piece piece : board.getBlackPieces()) {
            int position = piece.getCurrentPos();
            int row = position / 10;
            int col = position % 10;
            String symbol = piece.getSymbol();
            boardLayout[row][col] = symbol;
        }

        for (int i = 8; i >= 1; i--) {
            for (int j = 1; j <= 8; j++) {
                System.out.print(boardLayout[i][j] + " ");
            }
            System.out.println();
        }

    }

    public void printInvalidMove() {
        System.out.println("Invalid Move");
    }

}
