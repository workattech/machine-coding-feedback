package com.machine_coding.snakes_and_ladders.entities;

public class Board extends Entity{

    private int size;
    private Snake[] snakes;
    private Ladder[] ladders;
    private Player[] players;
    private int currentPlayer;

    public Board(Integer id) {
        super(id);
        this.currentPlayer = -1;
    }

    public int getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(int currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public int getSize() {
        return size;
    }

    public Snake[] getSnakes() {
        return snakes;
    }

    public Ladder[] getLadders() {
        return ladders;
    }

    public Player[] getPlayers() {
        return players;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setSnakes(Snake[] snakes) {
        this.snakes = snakes;
    }

    public void setLadders(Ladder[] ladders) {
        this.ladders = ladders;
    }

    public void setPlayers(Player[] players) {
        this.players = players;
    }
}