package com.game2048;

public class BoardManager {
    private int boardRows;
    private int boardColumns;
    BoardService boardService;

    public BoardManager(int boardRows, int boardColumns) {
        this.boardRows = boardRows;
        this.boardColumns = boardColumns;
        boardService = new BoardService(boardRows, boardColumns);
    }

    public void makeLeftDirectionMoves() {
        boardService.slidTilesInLeftDirection();
        boardService.mergeTilesinLeftDirection();
        boardService.slidTilesInLeftDirection();
    }

    public void makeRightDirectionMoves() {
        boardService.slidTilesInRightDirection();
        boardService.mergeTilesInRightDirection();
        boardService.slidTilesInRightDirection();
    }

    public void makeTopDirectionMoves() {
        boardService.slideTilesInTopDirection();
        boardService.mergeTilesInTopDirection();
        boardService.slideTilesInTopDirection();
    }

    public void makeBottomDirectionMoves() {
        boardService.slideTilesInBottomDirection();
        boardService.mergeTilesInBottomDirection();
        boardService.slideTilesInBottomDirection();
    }
}
