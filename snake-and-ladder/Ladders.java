import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Ladders implements Entities {
    private Map<Integer, Integer> positions = new HashMap<Integer, Integer>();

    public Ladders(List<Position> positions) {
        for (int i = 0; i < positions.size(); ++i) {
            Position position = positions.get(i);
            this.positions.put(position.key(), position.value());
        }
    }

    @Override
    public Boolean isPresent(Integer position) {
        return positions.containsKey(position);
    }

    @Override
    public Integer getNextValue(Integer position) {
        return positions.get(position);
    }
}
