package gamemodel;

/**
 * @author r.shukla
 */
public class GameEnhancement implements GameModel {

    private int startPosition;

    private int endPosition;

    public GameEnhancement(int startPosition, int endPosition) {
        this.startPosition = startPosition;
        this.endPosition = endPosition;
    }

    /**
     *
     * @return
     */
    public int getfinalPosition() {
        return endPosition;
    }

    public int getStartPosition() {
        return startPosition;
    }

    public int getEndPosition() {
        return endPosition;
    }
}
