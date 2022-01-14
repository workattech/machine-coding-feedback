package com.hitesh.TicTacToe.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Player {

    private String id;
    private String name;
    private Piece pieceTaken;

}
