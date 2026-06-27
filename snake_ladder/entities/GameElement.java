package snake_ladder.entities;

public abstract class GameElement {

    private final int startPosition;
    private final int endPosition;

    GameElement(int startPosition, int endPosition) {
        this.startPosition = startPosition;
        this.endPosition = endPosition;
    }

    public int getStartPosition() {
        return this.startPosition;
    }

    public int getEndPosition() {
        return this.endPosition;
    }

    public abstract int act();

}
