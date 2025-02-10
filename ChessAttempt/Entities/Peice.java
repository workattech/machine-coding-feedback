package Entities;

public abstract class Peice {
    private boolean isWhite;
    private String name;

    public Peice(boolean isWhite,String name){
        this.isWhite =isWhite;
        this.name=name;
    }

    public boolean isWhite(){
        return isWhite;
    }

    public String getName(){
        return name;
    }


    public abstract boolean isValidMove(ChessBoard board, int startX, int startY, int endX, int endY);

}
