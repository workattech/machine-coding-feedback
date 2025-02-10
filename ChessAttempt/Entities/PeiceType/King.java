package Entities.PeiceType;

import Entities.ChessBoard;
import Entities.Peice;

public class King extends Peice {
    public King(boolean isWhite,String name){
        super(isWhite,name);
    }

    public boolean isValidMove(ChessBoard board, int startX, int startY, int endX, int endY){
        int x = Math.abs(startX-endX);
        int y = Math.abs(startY-endY);

        if(x<=1 && y<=1){
            Peice p = board.getPeice(endX,endY);
            return p == null || p.isWhite() != isWhite();
        }
        return false;
    }
}
