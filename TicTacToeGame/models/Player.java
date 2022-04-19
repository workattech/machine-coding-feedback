package models;

public class Player {
    private char symbol;
    private String name;

    public Player(String name, char symbol) {
        this.name = name;
        this.symbol = symbol; // symbol must be unqiue for each player
    }

    public char getSymbol() {
        return this.symbol;
    }

    public String getName() {
        return this.name;
    }
}
