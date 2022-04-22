package model;

import services.BoardService;

import java.util.ArrayList;
import java.util.List;

public class Bishop extends Piece {
    public Bishop(PlayerColour playerColour, int currentPos) {
        super(playerColour, currentPos);
    }

    @Override
    public List<Integer> getPath(String endPos) {
        List<Integer> path = new ArrayList<>();
        int currentPosition = getCurrentPos();
        int targetPosition = BoardService.getTransformedCoordinate(endPos);

        int startCol = currentPosition/10;
        int startRow = currentPosition%10;
        int endCol   = targetPosition/10;
        int endRow   = targetPosition%10;

        if(endCol > startCol) {
            if(endRow > startRow) {
                while(startCol!=endCol && startRow!=endRow) {
                    startCol++;
                    startRow++;
                    path.add((startCol*10)+startRow);
                }
            }else if(endRow <  startRow) {
                while(startCol!=endCol && startRow!=endRow) {
                    startCol++;
                    startRow--;
                    path.add((startCol * 10) + startRow);
                }
            }
        } else if(endCol < startCol) {
            if(endRow > startRow) {
                while(startCol!=endCol && startRow!=endRow) {
                    startCol--;
                    startRow++;
                    path.add((startCol*10)+startRow);
                }
            }else if(endRow <  startRow) {
                while(startCol!=endCol && startRow!=endRow) {
                    startCol--;
                    startRow--;
                    path.add((startCol * 10) + startRow);
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
