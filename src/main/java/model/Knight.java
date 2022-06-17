package model;

import services.BoardService;

import java.util.ArrayList;
import java.util.List;

public class Knight extends Piece {
    public Knight(PlayerColour playerColour, int currentPos, String symbol) {
        super(playerColour, currentPos, symbol);
    }

    @Override
    public List<Integer> getPath(String position, Boolean canKillOpponent) {
        int dirs[] = new int[]{21, -21, 19, -19, 12, -12, 8, -8};
        int startPosition = getCurrentPos();
        int endingPosition = BoardService.getTransformedCoordinate(position);
        List<Integer> path = new ArrayList<>();
        for (int offset : dirs) {
            int new_position = startPosition + offset;
            if (new_position == endingPosition) {
                path.add(endingPosition);
                break;
            }
        }
        return path;
    }

    @Override
    boolean validate() {
        return false;
    }
}
