package Entities.PeiceType;

import Entities.ChessBoard;
import Entities.Peice;

public class Pawn extends Peice {
    public Pawn(boolean isWhite,String name){
        super(isWhite,name);
    }
    public boolean isValidMove(ChessBoard board, int startX, int startY, int endX, int endY){
        int direction = isWhite()?-1:1;

        if (startY == endY) {
            // Move forward
            if (startX + direction == endX && board.getPeice(endX, endY) == null) {
                return true;
            }
            // First move: two steps
            if ((startX == 1 && !isWhite()) || (startX == 6 && isWhite())) {
                if (startX + 2 * direction == endX && board.getPeice(endX, endY) == null) {
                    return true;
                }
            }
        }else if(Math.abs(startY - endY) == 1  && startX+direction == endX){
            // dioganally capture
            Peice p = board.getPeice(endX,endY);
            if(p!=null && isWhite()!=p.isWhite()){
                return true;
            }
        }
        return false;



    }
}
