package tictactoe.tictactoePackage.models;

public class Player {
    private String name;
    private Character  piece;
    public Player(String name, Character piece){
        this.name = name;
        this.piece = piece;
    }
    public String getName(){
        return name;
    }
    public Character  getPiece(){
        return piece;
    }
}