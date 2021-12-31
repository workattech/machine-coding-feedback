package models;

import java.util.HashMap;
import java.util.Map;

public class GameTurn extends BaseModel {
    private Direction direction;
    private Map<String, Direction> inputToDirectionMap;

    public GameTurn(String input) {
        super();
        this.inputToDirectionMap = new HashMap<>();
        // TODO need to implement this differently
        this.inputToDirectionMap.put("0", new Direction(0, -1));
        this.inputToDirectionMap.put("1", new Direction(0, 1));
        this.inputToDirectionMap.put("2", new Direction(-1, 0));
        this.inputToDirectionMap.put("3", new Direction(1, 0));
        this.direction = inputToDirectionMap.get(input);
    }

    public Direction getDirection() {
        return direction;
    }
}
