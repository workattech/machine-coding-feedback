package model;

import services.BoardService;

import java.util.ArrayList;
import java.util.List;

public class Bishop extends Piece {
    public Bishop(PlayerColour playerColour, int currentPos, String symbol) {
        super(playerColour, currentPos, symbol);
    }

    @Override
    public List<Integer> getPath(String endPos, Boolean canKillOpponent) {
        List<Integer> path = new ArrayList<>();
        int currentPosition = getCurrentPos();
        int targetPosition = BoardService.getTransformedCoordinate(endPos);

        int startCol = currentPosition % 10;
        int startRow = currentPosition / 10;
        int endCol = targetPosition % 10;
        int endRow = targetPosition / 10;

        if (endCol > startCol) {
            if (endRow > startRow) {
                while (startCol != endCol && startRow != endRow) {
                    startCol++;
                    startRow++;
                    path.add((startRow * 10) + startCol);
                }
            } else if (endRow < startRow) {
                while (startCol != endCol && startRow != endRow) {
                    startCol++;
                    startRow--;
                    path.add((startRow * 10) + startCol);
                }
            }
        } else if (endCol < startCol) {
            if (endRow > startRow) {
                while (startCol != endCol && startRow != endRow) {
                    startCol--;
                    startRow++;
                    path.add((startRow * 10) + startCol);
                }
            } else if (endRow < startRow) {
                while (startCol != endCol && startRow != endRow) {
                    startCol--;
                    startRow--;
                    path.add((startRow * 10) + startCol);
                }
            }
        }
        return path;
    }

    @Override
    boolean validate() {
        return false;
    }

}
