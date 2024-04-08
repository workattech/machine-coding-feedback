package models;

import java.util.HashMap;
import java.util.Map;

public class Ladders {
    private final Map<Integer, Integer> ladderPositions;

    public Ladders() {
        this.ladderPositions = new HashMap<>();
    }

    public Map<Integer, Integer> getLadderPositions() {
        return ladderPositions;
    }

    public void addLadders(int start, int end) {
        this.ladderPositions.put(start, end);
    }
}
