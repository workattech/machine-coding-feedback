import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private Integer a;
    private List<Integer> arr;

    public Integer getA() {
        return a;
    }

    public void setA(Integer a) {
        this.a = a;
    }

    public List<Integer> getArr() {
        return arr;
    }

    public void setArr(List<Integer> arr) {
        this.arr = arr;
    }

    public static void main(String[] args) throws Exception {
        Map<Temp, Integer> mp = new HashMap<>();
        mp.put(new Temp(3), null);
        mp.put(null, null);
        System.out.println("first java program");
        SnakeAndLadder snakeAndLadder = new SnakeAndLadder();
        snakeAndLadder.startGame();
    }
}
