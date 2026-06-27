package snake_ladder.entities;

public class Player {

    private final String name;
    private int position;

    public Player(String name) {
        this.name = name;
    }

    public Player(String name, int startPosition) {
        this.name = name;
        this.position = startPosition;
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

}
