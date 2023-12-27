package src.snake_and_ladder;

/**
 * denotes a particular position of an entity, it's start & end.
 */
public class Position {
    private int start;
    private int end;

    public Position(int start, int end) {
        int boardSize = GameConfig.getInstance().getBoardSize();
        if (start < boardSize || end < boardSize) {
            throw new IllegalArgumentException("Start and end of an entity is bounded by board size!");
        }
        this.start = start;
        this.end = end;
    }

    int getStart() {
        return start;
    }

    int getEnd() {
        return end;
    }
}
