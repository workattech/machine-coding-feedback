package tech.workat.snakeladders.impl.domain.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SnakesAndLaddersBoard extends Board{

    private List<Ladder> ladders;

    private List<Snake> snakes;

    private HashMap<Player, Integer> playerPositions;

    public SnakesAndLaddersBoard(int maxBoardSize){
        super(0,maxBoardSize);
        ladders = new ArrayList<>();
        snakes = new ArrayList<>();
        playerPositions = new HashMap<>();
    }

    public SnakesAndLaddersBoard(List<Ladder> ladders, List<Snake> snakes, int startPosition, int endPosition,
                                 int maxPosition, HashMap<Player, Integer> playerPositions) {
        super(startPosition, endPosition);
        this.ladders = ladders;
        this.snakes = snakes;
        this.playerPositions = playerPositions;
    }

    public List<Ladder> getLadders() {
        return ladders;
    }

    public void setLadders(List<Ladder> ladders) {
        this.ladders = ladders;
    }

    public List<Snake> getSnakes() {
        return snakes;
    }

    public void setSnakes(List<Snake> snakes) {
        this.snakes = snakes;
    }

    public HashMap<Player, Integer> getPlayerPositions() {
        return playerPositions;
    }

    public void setPlayerPositions(HashMap<Player, Integer> playerPositions) {
        this.playerPositions = playerPositions;
    }

}
