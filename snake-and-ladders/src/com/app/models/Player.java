package com.app.models;

public class Player {

    private String Name;
    private int currentPosition;

    String getName() {
        return Name;
    }

    int getCurrentPosition() {
        return currentPosition;
    }

    void setCurrentPosition(int currentPosition) {
        this.currentPosition = currentPosition;
    }

    public Player(String name, int currentPosition) {
        Name = name;
        this.currentPosition = currentPosition;
    }

    int makeMove(Die die)
    {
        int iterations = 0, moves = 0;
        while (moves == 0 || (die.getCurrentFace()== 6 && iterations < 3))
        {
            die.roll();
            moves += die.getCurrentFace();
            iterations++;
            System.out.println(this.Name+" rolled a "+die.getCurrentFace());
        }
        return (iterations==3 && moves%6==0)?0:moves;
    }

}
