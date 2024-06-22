import java.util.Map;
import java.util.HashMap;

public class Board {
  private int size;
  private Map<Integer, Integer> snakes;
  private Map<Integer, Integer> ladders;

  public Board(int size) {
    this.size = size;
    this.snakes = new HashMap<>();
    this.ladders = new HashMap<>();
  }

  public void addSnake(int head, int tail) {
    snakes.put(head, tail);
  }

  public void addLadder(int start, int end) {
    ladders.put(start, end);
  }

  public int getNewPosition(int currentPosition) {
    while (snakes.containsKey(currentPosition) || ladders.containsKey(currentPosition)) {
      if (snakes.containsKey(currentPosition)) {
        currentPosition = snakes.get(currentPosition);
      } else if (ladders.containsKey(currentPosition)) {
        currentPosition = ladders.get(currentPosition);
      }
    }

    return currentPosition;
  }

  public int getSize() {
    return size;
  }
}