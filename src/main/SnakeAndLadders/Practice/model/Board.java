package SnakeAndLadders.Practice.model;

import java.util.List;
import java.util.Map;

public class Board {
    private Dice dice;
    private List<Player> players;
    private Map<Integer, Ladder> ladders;
    private Map<Integer, Snake> snakes;

    public Dice getDice() {
        return dice;
    }

    public void setDice(Dice dice) {
        this.dice = dice;
    }



    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public Map<Integer, Ladder> getLadders() {
        return ladders;
    }

    public void setLadders(Map<Integer, Ladder> ladders) {
        this.ladders = ladders;
    }

    public Map<Integer, Snake> getSnakes() {
        return snakes;
    }

    public void setSnakes(Map<Integer, Snake> snakes) {
        this.snakes = snakes;
    }

    public Player getPlayerWithId(int id) { return players.get(id); }

    public Snake getSnakeWithPosition(int position) { return snakes.getOrDefault(position,null); }

    public Ladder getLadderWithPosition(int position) { return ladders.getOrDefault(position,null); }


}
