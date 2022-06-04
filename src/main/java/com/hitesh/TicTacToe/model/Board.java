package com.hitesh.TicTacToe.model;

import com.hitesh.TicTacToe.constant.Constants;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Board {

    private String id;
    private List<List<Cell>> cellList;

    public Board(String id, List<List<Cell>> cellList) {
        this.id = id;
        this.cellList = cellList;
        initialize();
    }

    private void initialize() {

        for(int i=0;i<Constants.NO_OF_ROWS;i++){

            List<Cell> newCells = new ArrayList<>();

            for(int j=0;j<Constants.NO_OF_COLS;j++){
                newCells.add(new Cell(i,j, null));
            }

            cellList.add(newCells);
        }
    }

    boolean isCellOccupied(Cell cell){

        return cellList.get(cell.getX()).get(cell.getY()).getPiece() != null;
    }

    public void assignPieceToCell(Cell cell, Piece piece) {
        cellList.get(cell.getX()).get(cell.getY()).assignPiece(piece);
    }

    public void print(){

        for(int i=0;i<Constants.NO_OF_ROWS;i++){
            for(int j=0;j<Constants.NO_OF_COLS;j++){

                Cell cell = cellList.get(i).get(j);
                if(isCellOccupied(cell)){
                    System.out.print(cell.getPiece().getValue() + " ");
                }
                else{
                    System.out.print("- ");
                }
            }
            System.out.println();
        }

    }

}
