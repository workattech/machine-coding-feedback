package snake_ladder.entities;

public class Ladder extends GameElement{

    public Ladder(int startPosition, int endPosition) {
        super(startPosition, endPosition);
    }

    public int act() {
        return this.getEndPosition();
    }

}
