import java.util.List;

public class SnakeAndLadderBoard {
    private List<Snake> snakes;
    private List<Ladder> ladders;
    private static final int DEFAULT_BOARD_SIZE = 100;
    private int size;

    public SnakeAndLadderBoard(List<Snake> snakes, List<Ladder> ladders) {
        this.snakes = snakes;
        this.ladders = ladders;
        this.size = DEFAULT_BOARD_SIZE;
    }
    public List<Snake> getSnakes() {
        return snakes;
    }

    public List<Ladder> getLadders() {
        return ladders;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
