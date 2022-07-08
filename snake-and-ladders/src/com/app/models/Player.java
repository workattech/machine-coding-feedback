package com.app.models;

public class Player {

    private String Name;
    private int currentPosition;

    public String getName() {
        return Name;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(int currentPosition) {
        this.currentPosition = currentPosition;
    }

    public Player(String name, int currentPosition) {
        Name = name;
        this.currentPosition = currentPosition;
    }

    public void makeMove(Die die)
    {
        die.roll();
    }

    public boolean checkWinner(Board board)
    {
        return (this.currentPosition == board.getSize());
    }

}
