package model;

import java.util.List;

public abstract class Piece {
    private PlayerColour playerColour;
    private int currentPos;
    private String symbol;

    public Piece(PlayerColour playerColour, int currentPos, String symbol) {
        this.playerColour = playerColour;
        this.currentPos = currentPos;
        this.symbol = symbol;
    }

    public abstract List<Integer> getPath(String position, Boolean canKillOpponent);

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

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
}
