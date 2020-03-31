import java.util.HashMap;
import java.util.Map;

public class LaddersMap {
    private Map<Integer,Integer> mp;
    private int numberOfLadders;

    public LaddersMap(int numberOfLadders){

        this.numberOfLadders = numberOfLadders;
        mp = new HashMap<>();
    }

    void addLadder(int start,int end){
        mp.put(start,end);
    }

    int steppedOnLadder(int start){
        return mp.getOrDefault(start,-1);
    }

    public int getNumberOfLadders() {
        return numberOfLadders;
    }
}
