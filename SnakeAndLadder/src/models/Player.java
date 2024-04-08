package models;

public class Player {
    private final String name;
    private int currentCell;

    public Player(String name) {
        this.name = name;
        this.currentCell = 0;
    }

    public String getName() {
        return name;
    }

    public int getCurrentCell() {
        return currentCell;
    }

    public void setCurrentCell(int currentCell) {
        this.currentCell = currentCell;
    }
}
