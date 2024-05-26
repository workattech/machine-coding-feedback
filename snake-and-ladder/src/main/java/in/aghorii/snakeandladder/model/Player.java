package in.aghorii.snakeandladder.model;

public class Player {

    private final String name;
    private int position;

    public Player(String name) {
        this.name = name;
        position = 0;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
