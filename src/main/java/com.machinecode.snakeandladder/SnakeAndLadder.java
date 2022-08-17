package com.machinecode.snakeandladder;

import java.util.HashMap;
import java.util.List;

public class SnakeAndLadder {
    public static final int BOARD_START = 1;
    public static final int BOARD_END = 100;
    private List<Player> players;
    private HashMap<Integer, Integer> snakes, ladders;
    private Dice dice;

    void play() {
        int currentPlayerIndex = 0;
        while (true) {
            Player currentPlayer = players.get(currentPlayerIndex);
            currentPlayer.play(this);

            currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
        }
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayer(List<Player> players) {
        this.players = players;
    }

    public HashMap<Integer, Integer> getSnakes() {
        return snakes;
    }

    public void setSnakes(HashMap<Integer, Integer> snakes) {
        this.snakes = snakes;
    }

    public HashMap<Integer, Integer> getLadders() {
        return ladders;
    }

    public void setLadders(HashMap<Integer, Integer> ladders) {
        this.ladders = ladders;
    }

    public Dice getDice() {
        return dice;
    }

    public void setDice(Dice dice) {
        this.dice = dice;
    }
}
