package com.entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Board {
    private List<Snake> snakes;
    private List<Ladder> ladders;
    private List<Player> players;
    private Map<String, Integer> playerPositions;

    public Board() {
        snakes = new ArrayList<>();
        ladders = new ArrayList<>();
        players = new ArrayList<>();
        playerPositions = new HashMap<>();
    }

    public void addSnake(int head, int tail) {
        Snake snake = new Snake(head, tail);
        snakes.add(snake);
    }

    public void addLadder(int start, int end) {
        Ladder ladder = new Ladder(start, end);
        ladders.add(ladder);
    }

    public void addPlayer(String playerName) {
        Player player = new Player(playerName, 0);
        players.add(player);
        playerPositions.put(playerName, 0);
    }

    public List<Player> getPlayers() {
        return players;
    }

    public List<Snake> getSnakes() {return snakes;
    }

    public List<Ladder> getLadders() {
        return ladders;
    }
}
