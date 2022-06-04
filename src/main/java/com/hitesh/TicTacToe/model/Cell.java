package com.hitesh.TicTacToe.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Cell {

    private int x;
    private int y;
    private Piece piece;

    @Override
    public boolean equals(Object obj) {

        if(obj == null || obj.getClass()!=this.getClass()){
            return false;
        }

        Cell other = (Cell) obj;

        return this.x == other.x && this.y == other.y;
    }

    public void assignPiece(Piece piece) {
        this.piece = piece;
    }
}
