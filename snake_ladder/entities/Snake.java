package snake_ladder.entities;

public class Snake extends GameElement{

    public Snake(int startPosition, int endPosition) {
        super(startPosition, endPosition);
    }

    public int act() {
        return this.getEndPosition();
    }

}
