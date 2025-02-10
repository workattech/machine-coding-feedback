package Entities.PeiceType;

import Entities.ChessBoard;
import Entities.Peice;

public class Knight extends Peice {
    public Knight(boolean isWhite,String name){
        super(isWhite,name);
    }

    public boolean isValidMove(ChessBoard board, int startX, int startY, int endX, int endY){
        int x = Math.abs(startX-endX);
        int y = Math.abs(startY-endY);

        if ((x== 2 && y == 1) || (x== 1 && y == 2)) {
            Peice p = board.getPeice(x,y);
            return p == null || p.isWhite() != isWhite();
        }
        return false;
    }
}

