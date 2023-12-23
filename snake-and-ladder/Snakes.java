import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Snakes implements Entities {
    Map<Integer, Integer> positions = new HashMap<Integer, Integer>();

    public Snakes(List<Position> positions) {
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
