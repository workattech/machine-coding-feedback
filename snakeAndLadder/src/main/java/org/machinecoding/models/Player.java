package org.machinecoding.models;

public class Player {
    private final String name;
    private int position;
    private final int targetPosition;

    public Player(String name, int startPosition, int targetPosition){
        this.name = name;
        this.position = startPosition;
        this.targetPosition = targetPosition;
    }

    public void move(int newPosition){
        this.position = (newPosition > targetPosition) ? position : newPosition;
    }

    public boolean isWinner(){
        return (position == targetPosition);
    }

    public int getPosition(){
        return position;
    }

    public String getName(){
        return name;
    }
}
