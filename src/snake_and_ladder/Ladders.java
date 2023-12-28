package src.snake_and_ladder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Ladders implements BoardEntity {
    private Map<Integer, Integer> positions = new HashMap<Integer, Integer>();

    public Ladders(List<Position> positions) {
        for (Position position : positions) {
            this.positions.put(position.getStart(), position.getEnd());
        }
    }

    @Override
    public boolean isPresent(int position) {
        return positions.containsKey(position);
    }

    @Override
    public int getDestinationPosition(int position) {
        if (!isPresent(position))
            return position;
        return positions.get(position);
    }
}
