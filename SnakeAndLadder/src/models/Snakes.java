package models;

import java.util.HashMap;
import java.util.Map;

public class Snakes {
    private final Map<Integer, Integer> snakePositions;

    public Snakes() {
        this.snakePositions = new HashMap<>();
    }

    public Map<Integer, Integer> getSnakePositions() {
        return snakePositions;
    }

    public void addSnakes(int start, int end) {
        this.snakePositions.put(start, end);
    }
}
