import java.util.*;
import java.lang.*;
import java.io.*;
import Board.java;
import Ladder.java;
import Snake.java;
import Player.java;


class Board {
    private int boardSize;
    private Snake snakesList[];
    private Ladder ladderList[];
    private HashMap<Integer, Integer> snakesAndLadderList;


    public Board(Integer boardSize, Snake snakesList[], Ladder ladderList[]){
        this.boardSize = boardSize;
        this.snakesList = snakesList;
        this.ladderList = ladderList;
        this.snakesAndLadderList = new HashMap<Integer, Integer>();
    }
    
    public void snakeSetupAtBoard(){
        Snake tempSnakesList[] = this.snakesList;
        for(int i=0;i<tempSnakesList.length;i++){
            int startingPoint = tempSnakesList[i].getSnakeStartingPosition();
            int endingPoint = tempSnakesList[i].getSnakeEndingPosition();
            snakesAndLadderList.put(startingPoint, endingPoint);
        }
    }

    public void ladderSetupAtBoard(){
        Ladder tempLadderList[] = this.ladderList;
        for(int i=0;i<tempLadderList.length;i++){
            int startingPoint = tempLadderList[i].getLadderStartingPosition();
            int endingPoint = tempLadderList[i].getLadderEndingPosition();
            snakesAndLadderList.put(startingPoint, endingPoint);
        }
    }

    public HashMap<Integer, Integer> getSnakesAndLadderList(){
        return this.snakesAndLadderList;
    }

}


// The game is played with two dice instead of 1 and so the total dice value could be between 2 to 12 in a single move.
// In case of more than 2 players, the game continues until only one player is left.
// On getting a 6, you get another turn and on getting 3 consecutive 6s, all the three of those get cancelled.
// On starting the application, the snakes and ladders should be created programmatically without any user input, keeping in mind the constraints mentioned in rules.