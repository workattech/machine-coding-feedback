package model;

import java.util.List;

public abstract class Piece {
    private PlayerColour playerColour;
    private int currentPos;

    public Piece(PlayerColour playerColour, int currentPos) {
        this.playerColour = playerColour;
        this.currentPos = currentPos;
    }

    public abstract List<Integer> getPath(String position);

    abstract boolean validate();

    public PlayerColour getPlayerColour() {
        return playerColour;
    }

    public void setPlayerColour(PlayerColour playerColour) {
        this.playerColour = playerColour;
    }

    public int getCurrentPos() {
        return currentPos;
    }

    public void setCurrentPos(int currentPos) {
        this.currentPos = currentPos;
    }
}
