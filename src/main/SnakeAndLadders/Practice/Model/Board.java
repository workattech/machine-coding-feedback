package SnakeAndLadders.Practice.Model;

import java.util.List;
import java.util.Map;

public class Board {
    private Dice dice;
    private List<Players> players;
    private Map<Integer,Ladders> ladders;
    private Map<Integer,Snakes> snakes;

    public Dice getDice() {
        return dice;
    }

    public void setDice(Dice dice) {
        this.dice = dice;
    }



    public List<Players> getPlayers() {
        return players;
    }

    public void setPlayers(List<Players> players) {
        this.players = players;
    }

    public Map<Integer, Ladders> getLadders() {
        return ladders;
    }

    public void setLadders(Map<Integer, Ladders> ladders) {
        this.ladders = ladders;
    }

    public Map<Integer, Snakes> getSnakes() {
        return snakes;
    }

    public void setSnakes(Map<Integer, Snakes> snakes) {
        this.snakes = snakes;
    }
}
