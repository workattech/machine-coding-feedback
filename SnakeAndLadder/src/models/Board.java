package models;

public class Board {
    private final Snakes snakes;
    private final Ladders ladders;
    private final Player[] player;
    private final int dice;
    private boolean isDone;
    private final int numberOfCells;

    public Board(Snakes snakes, Ladders ladders, Player[] player, int dice, int numberOfCells) {
        this.snakes = snakes;
        this.ladders = ladders;
        this.player = player;
        this.dice = dice;
        this.isDone = false;
        this.numberOfCells = numberOfCells;
    }

    public Snakes getSnakes() {
        return snakes;
    }

    public Ladders getLadders() {
        return ladders;
    }

    public Player[] getPlayer() {
        return player;
    }

    public int getDice() {
        return dice;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    public int getNumberOfCells() {
        return numberOfCells;
    }

}
