package com.nirley.mock.player;

public class Player {

    private PlayerKey playerKey;
    private int position;
    private String name;

    public Player(PlayerKey playerKey, String name) {
        this.playerKey = playerKey;
        this.position = 0;
        this.name = name;
    }

    public PlayerKey getPlayerKey() {
        return playerKey;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
