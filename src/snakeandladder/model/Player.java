package snakeandladder.model;

public class Player {
    String name;
    int position=0;
    boolean hasWon =false;
    public Player(String name) {
        this.name = name;
    }

    public boolean checkHasWon() {
        return hasWon;
    }

    public void setHasWon() {
        hasWon = true;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
