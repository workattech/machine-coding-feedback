package Entities;

public class Player {
    private String Name;
    private Peice peice;

    public Player(String Name,Peice p){
        this.Name = Name;
        this.peice = p;
    }

    public String getName() {
        return Name;
    }

    public char getPeice() {
        return peice.peicetype.charAt(0);
    }
}
