package com.workattech.snakesandladders.game;


public class Player {

    /**
     * name would only be set in the beginning, no setter for name , only getter
     * for game status , its initialized in beginning as false, setter and getter both available
     * for position, in beginning it is set as 0 and both setter and getter are available
     */
    private String name;
    private boolean game_status;
    private int position;

    Player(String name) {
        this.name = name;
        this.position = 0;
        this.game_status = false;
    }

    public String getName() {
        return name;
    }

    public boolean getGame_status() {
        return game_status;
    }

    public void setGame_status(boolean game_status) {
        this.game_status = game_status;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

}