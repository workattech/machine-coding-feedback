import java.util.*;
import java.lang.*;
import java.io.*;
import Board.java;
import Ladder.java;
import Snake.java;
import Player.java;

public class snakeAndLadderExe {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        
        Integer numberOfSnakes;
        numberOfSnakes = scanner.nextInt();
        Snake snakesList[] = new Snake[numberOfSnakes];
        for(int i=0;i<numberOfSnakes;i++){
            int startingSnakePoint, endingSnakePoint;
            startingSnakePoint = scanner.nextInt();
            endingSnakePoint = scanner.nextInt();
            snakesList[i] = new Snake(startingSnakePoint, endingSnakePoint);
        }

        Integer numberOfLadders;
        numberOfLadders = scanner.nextInt();
        Ladder laddersList[] = new Ladder[numberOfLadders];
        for(int i=0;i<numberOfLadders;i++){
            int startingLadderPoint, endingLadderPoint;
            startingLadderPoint = scanner.nextInt();
            endingLadderPoint = scanner.nextInt();
            laddersList[i] = new Ladder(startingLadderPoint, endingLadderPoint);
        }

        int numberOfPlayers;
        numberOfPlayers = scanner.nextInt();
        Player[] playersList = new Player[numberOfPlayers];
        for(int i=0;i<numberOfPlayers;i++){
            String playerName = scanner.next();
            playersList[i] = new Player(playerName);
        }
        
        Board board = new Board(100, snakesList,laddersList);
        board.snakeSetupAtBoard();
        board.ladderSetupAtBoard();
        
        HashMap<Integer, Integer> snakesAndLadderList = board.getSnakesAndLadderList();
        Boolean flag = true, done = false;
        System.out.println("Start");
        while(flag){
            for(int i=0;i<numberOfPlayers;i++){
                int diceValue = (int)(Math.random()*(6)+1);  
                int currentPosition = playersList[i].getPlayerPosition();
                int newPosition = currentPosition + diceValue;

                if(newPosition<100){
                    while(snakesAndLadderList.containsKey(newPosition)){
                        newPosition = snakesAndLadderList.get(newPosition);
                    }
                }
                playersList[i].setPlayerPosition(newPosition);
                if(newPosition == 100){
                    System.out.println(playersList[i].getPlayerName() + " wins the game");
                    done = true;
                    break;
                }
                System.out.println( playersList[i].getPlayerName() +" rolled a " + diceValue +" and moved from "+ currentPosition+" to "+ newPosition);
            }
            if(done) break;
        }
    }
}