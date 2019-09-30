import java.util.HashMap;
import java.util.Map;

public class SnakesMap {

    private Map<Integer,Integer> mp;
    int numberOfSnakes;

    public SnakesMap(int numberOfSnakes){
        this.numberOfSnakes = numberOfSnakes;
        mp = new HashMap<>();
    }

    void addSnake(int head,int tail){
        mp.put(head,tail);
    }

    int steppedOnSnake(int from){
        return mp.getOrDefault(from,-1);
    }

    public int getNumberOfSnakes() {
        return numberOfSnakes;
    }
}
