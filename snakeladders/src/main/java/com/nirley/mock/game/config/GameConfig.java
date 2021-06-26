package com.nirley.mock.game.config;

import com.nirley.mock.dice.Dice;
import com.nirley.mock.dice.Dice;

import java.util.List;
import java.util.Map;

public class GameConfig {

    private int totalCells;
    private int startPoint;
    private int endPoint;
    private Map<Integer, Integer> snakes;
    private Map<Integer, Integer> ladders;
    private List<Dice> dices;

    public GameConfig(int totalCells, int startPoint, Map<Integer, Integer> snakes, Map<Integer, Integer> ladders,  List<Dice> dices) {
        this.totalCells = totalCells;
        this.startPoint = startPoint;
        this.endPoint = startPoint + totalCells;
        this.snakes = snakes;
        this.ladders = ladders;
        this.dices = dices;
    }

    public List<Dice> getDices() {
        return dices;
    }

    public int getStartPoint() {
        return startPoint;
    }

    public int getEndPoint() {
        return endPoint;
    }

    public Map<Integer, Integer> getSnakes() {
        return snakes;
    }

    public Map<Integer, Integer> getLadders() {
        return ladders;
    }

}
