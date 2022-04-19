package services;

import models.Board;

public class BoardService {
    private Board board;
    public BoardService(Board board) {
        this.board = board;
    }

    public Board getBoard() {
        return this.board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public boolean isValidMove(int r, int c) {
        if(this.isValidPosition(r, c) && this.isEmptyPosition(r, c)) return true;
        return false;
    }

    private boolean isValidPosition(int r, int c) {
        int boardSize = this.board.getSize();
        if (boardSize < r || boardSize < c) return false;
        return true;
    }

    // pass a valid position here
    private boolean isEmptyPosition(int r, int c) {
        if (this.board.getSymbolAt(r, c) == '-') return true;
        return false;
    }

    public void printBoard() {
        System.out.println("---------PRINTING BOARD----------");
        char[][] boardState = this.board.getBoardState();
        int sz = this.board.getSize();
        for(int row = 1; row <= sz; row++) {
            for(int col = 1; col <= sz; col++) {
                System.out.print(boardState[row][col]);
            }
            System.out.println();
        }
        System.out.println();
    }

    public void playMove(int r, int c, char piece) {
        this.board.setPieceAt(r, c, piece);
    }
}
