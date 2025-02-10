package Entities;

public class Player {
    private boolean isWhite;

    public Player(boolean isWhite){
        this.isWhite= isWhite;
    }
    public void switchPlayer(){
        this.isWhite = !isWhite;
    }
    public boolean isWhite(){
        return isWhite;
    }
}
