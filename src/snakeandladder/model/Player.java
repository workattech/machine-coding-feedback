package snakeandladder.model;

public class Player {
    String name;
    int position=0;
    boolean HasWon=false;
    public Player(String name) {
        this.name = name;
    }

    public boolean checkHasWon() {
        return HasWon;
    }

    public void setHasWon() {
        HasWon = true;
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
