package model;

import services.BoardService;

import java.util.ArrayList;
import java.util.List;

public class King extends Piece{
    public King(PlayerColour playerColour, int currentPos) {
        super(playerColour, currentPos);
    }

    @Override
    public List<Integer> getPath(String position) {
        List<Integer> path = new ArrayList<>();
        int startPosition  = getCurrentPos();
        int endingPosition = BoardService.getTransformedCoordinate(position);
        if(     startPosition + 1  == endingPosition ||
                startPosition - 1  == endingPosition ||
                startPosition + 10 == endingPosition ||
                startPosition - 10 == endingPosition ||
                startPosition + 11 == endingPosition ||
                startPosition - 11 == endingPosition ||
                startPosition + 9  == endingPosition ||
                startPosition - 9  == endingPosition
        )
            path.add(endingPosition);
        return path;
    }

    @Override
    boolean validate() {
        return false;
    }
}
