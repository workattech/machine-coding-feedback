package model;

import java.util.List;

public class Pawn extends Piece {

    private boolean isStart;

    public Pawn(PlayerColour playerColour, int currentPos) {
        super(playerColour, currentPos);
        isStart=false;
    }

    @Override
    public List<Integer> getPath(String position) {
        return null;
    }

    @Override
    boolean validate() {

        return false;
    }
}
