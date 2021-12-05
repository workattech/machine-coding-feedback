package com.ticTacToe.model;

import java.util.UUID;

public class Player {
    private String piece;
    private String name;

    public Player(String piece, String name) {
        this.piece = piece;
        this.name = name;
    }

    public String getPiece() {
        return piece;
    }

    public String getName() {
        return name;
    }
}