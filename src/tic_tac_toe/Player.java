package src.tic_tac_toe;

public class Player {
    private String name;

    public Player(String name, String piece) {
        this.name = name;
        this.piece = piece.charAt(0);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private char piece;

    public char getPiece() {
        return piece;
    }

    public void setPiece(char piece) {
        this.piece = piece;
    }
}
