package com.hitesh.TicTacToe.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@Getter
@NoArgsConstructor
public class State {

    private final Map<Piece,Integer> pieceCountMap = new HashMap<>();

    public boolean isPresent(int value) {
        return pieceCountMap.containsValue(value);
    }

    public void putPiece(Piece piece){
        pieceCountMap.put(piece, pieceCountMap.getOrDefault(piece,0) + 1);
    }
}
