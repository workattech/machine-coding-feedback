import java.util.*;
import java.lang.*;
import java.io.*;
import Board.java;
import Ladder.java;
import Snake.java;
import Player.java;

class Player {
    private String playerName;
    private int playerPosition;
    
    public Player(String playerName){
        this.playerName = playerName;
        this.playerPosition = 0;
    }

    public String getPlayerName(){
        return this.playerName;
    }

    public void setPlayerPosition(int playerPosition){
        this.playerPosition = playerPosition;
    }

    public int getPlayerPosition(){
        return this.playerPosition;
    }

}
