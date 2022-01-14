package com.hitesh.TicTacToe.model;

public class Move {

    public static boolean move(final Board board, final GameState gameState,
                               final Cell cell,
                               final  Piece piece){

        boolean isCellOccupied = board.isCellOccupied(cell);
        if(isCellOccupied){
            return false;
        }
        board.assignPieceToCell(cell, piece);
        gameState.updateState(cell,piece);
        return true;
    }
}
