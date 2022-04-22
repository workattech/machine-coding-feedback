package model;

import java.util.List;

public class Queen extends Piece{
    public Queen(PlayerColour playerColour, int currentPos) {
        super(playerColour, currentPos);
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
