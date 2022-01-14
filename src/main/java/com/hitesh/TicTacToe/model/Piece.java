package com.hitesh.TicTacToe.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Piece {
    private char value;

    @Override
    public int hashCode() {
        return value;
    }

    @Override
    public boolean equals(Object obj) {

        if(obj == null || obj.getClass() != this.getClass()){
            return false;
        }

        Piece other = (Piece) obj;

        return other.getValue() == this.getValue();
    }
}
