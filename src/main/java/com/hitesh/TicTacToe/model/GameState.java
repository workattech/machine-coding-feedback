package com.hitesh.TicTacToe.model;

import com.hitesh.TicTacToe.constant.Constants;

import java.util.ArrayList;
import java.util.List;

public class GameState {

    private List<State> rowState = new ArrayList<>();
    private List<State> colState = new ArrayList<>();

    public GameState() {

        for(int i=0;i<Constants.NO_OF_ROWS;i++){
            rowState.add(new State());
        }

        for(int i=0;i<Constants.NO_OF_COLS;i++){
            colState.add(new State());
        }

    }

    public void updateState(final Cell cell, final Piece piece){
        rowState.get(cell.getX()).putPiece(piece);
        colState.get(cell.getY()).putPiece(piece);
    }

    public boolean checkRows() {

        return rowState.stream()
                .anyMatch(state -> state.isPresent(Constants.NO_OF_ROWS));
    }

    public boolean checkCols() {

        return colState.stream()
                .anyMatch(state -> state.isPresent(Constants.NO_OF_COLS));
    }

    public boolean checkDiagonals(Board board) {

        List<List<Cell>> cellList = board.getCellList();

        Cell baseCell = cellList.get(0).get(0);

        if(board.isCellOccupied(baseCell)){
            boolean check = true;
            for(int i = 1;i < Constants.NO_OF_ROWS; i++){

                Cell cell = cellList.get(i).get(i);

                if(!board.isCellOccupied(cell) || !cell.getPiece().equals(baseCell.getPiece())){
                    check = false;
                    break;
                }
            }
            if(check){
                return true;
            }
        }

        baseCell = cellList.get(0).get(Constants.NO_OF_COLS-1);
        int j=1;

        if(board.isCellOccupied(baseCell)){
            boolean check = true;
            for(int i = 1;i < Constants.NO_OF_ROWS; i++){

                Cell cell = cellList.get(i).get(j);

                if(!board.isCellOccupied(cell) || !cell.getPiece().equals(baseCell.getPiece())){
                    check = false;
                    break;
                }
                j--;
            }
            if(check){
                return true;
            }
        }

        return false;
    }


    public boolean checkForWin(final Board board) {
        return checkRows() || checkCols() || checkDiagonals(board);
    }
}
