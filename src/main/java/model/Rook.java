package model;

import services.BoardService;

import java.util.ArrayList;
import java.util.List;

public class Rook extends Piece {

    public Rook(PlayerColour playerColour, int currentPos, String symbol) {
        super(playerColour, currentPos, symbol);
    }

    @Override
    public List<Integer> getPath(String position, Boolean canKillOpponent) {
        List<Integer> path = new ArrayList<>();
        int startingPosition = getCurrentPos();
        int endingPosition = BoardService.getTransformedCoordinate(position);
        int startRow = startingPosition / 10;
        int startCol = startingPosition % 10;
        int endRow = endingPosition / 10;
        int endCol = endingPosition % 10;
        if (startRow == endRow) {
            startCol = Math.min(startCol, endCol);
            endCol = Math.max(startCol, endCol);
            while (startCol <= endCol) {
                path.add((startRow * 10) + startCol);
                startCol++;
            }
        } else if (startCol == endCol) {
            startRow = Math.min(startRow, endRow);
            endRow = Math.max(startRow, endRow);
            while (startRow <= endRow) {
                path.add((startRow * 10) + startCol);
                startRow++;
            }
        }
        return path;
    }

    @Override
    boolean validate() {
        return false;
    }
}
