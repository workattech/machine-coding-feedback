package model;

import services.BoardService;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BinaryOperator;

public class Pawn extends Piece {

    private boolean isStart;
    private int initialPosition;


    public Pawn(PlayerColour playerColour, int currentPos, String symbol) {
        super(playerColour, currentPos, symbol);
        initialPosition = currentPos;
    }

    @Override
    public List<Integer> getPath(String position, Boolean canKillOpponent) {
        int startingPosition = getCurrentPos();
        int endingPosition = BoardService.getTransformedCoordinate(position);

        List<Integer> path = new ArrayList<>();
        if (getPlayerColour() == PlayerColour.WHITE) {
            if (canKillOpponent) {
                if ((startingPosition + 11 == endingPosition) || (startingPosition + 9 == endingPosition)) {
                    path.add(endingPosition);
                    return path;
                }
            }
            path.add(startingPosition + 10);
            if ((startingPosition == initialPosition) && (startingPosition + 20 == endingPosition)) {
                path.add(startingPosition + 20);
            }
        } else {
            if (canKillOpponent) {
                if ((startingPosition - 11 == endingPosition) || (startingPosition - 9 == endingPosition)) {
                    path.add(endingPosition);
                    return path;
                }
            }
            path.add(startingPosition - 10);
            if ((startingPosition == initialPosition) && (startingPosition - 20 == endingPosition)) {
                path.add(startingPosition - 20);
            }

        }
        return path;
    }

    @Override
    boolean validate() {

        return false;
    }
}
