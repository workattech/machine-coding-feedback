package com.game2048.models;

public class Game2048Tile {
    private String tile;

    public Game2048Tile(int tileNumber) {
        this.tile = "" + tileNumber;
    }

    public String getTile() {
        return tile;
    }

    public void setTile(String tile) {
        this.tile = tile;
    }
}
