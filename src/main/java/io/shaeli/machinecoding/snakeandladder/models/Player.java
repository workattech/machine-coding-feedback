package io.shaeli.machinecoding.snakeandladder.models;

public class Player {
    private String name;
    private boolean isPlaying;
    private int currentPos;

    public Player(String name) {
        this.name = name;
        this.isPlaying = false;
        this.currentPos = 0;
    }

    public boolean isPlaying() {
        return this.isPlaying;
    }

    public int getPos() {
        return currentPos;
    }

    public String getName() {
        return this.name;
    }

    public void setPos(int pos) {
        System.out.println("Player " + getName() + " moved from " + currentPos + " to " + pos);
        this.currentPos = pos;
    }

    public void setPlaying(boolean isPlaying) {
        this.isPlaying = isPlaying;
    }

}
