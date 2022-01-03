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
            snakesList[i] = new Snake(scanner.nextInt(), scanner.nextInt());
        }

        Integer numberOfLadders;
        numberOfLadders = scanner.nextInt();
        Ladder laddersList[] = new Ladder[numberOfLadders];
        for(int i=0;i<numberOfLadders;i++){
            laddersList[i] = new Ladder(scanner.nextInt(), scanner.nextInt());
        }

        int numberOfPlayers;
        numberOfPlayers = scanner.nextInt();
        Player[] playersList = new Player[numberOfPlayers];
        for(int i=0;i<numberOfPlayers;i++){
            playersList[i] = new Player(scanner.next());
        }
        
        Board board = new Board(100, snakesList,laddersList);
        board.snakeSetupAtBoard();
        board.ladderSetupAtBoard();
        
        HashMap<Integer, Integer> snakesAndLadderList = board.getSnakesAndLadderList();
        Boolean flag = true, gameFinishes = false;
        System.out.println("Start");
        while(flag){
            for(int i=0;i<numberOfPlayers;i++){
                int diceValue = (int)(Math.random()*(6)+1);  
                int currentPosition = playersList[i].getPlayerPosition();
                int newPosition;
                if(currentPosition + diceValue > 100){
                    newPosition = currentPosition;
                }
                else{
                    newPosition = currentPosition + diceValue;
                    while(snakesAndLadderList.containsKey(newPosition)){
                        newPosition = snakesAndLadderList.get(newPosition);
                    }
                }

                playersList[i].setPlayerPosition(newPosition);
                System.out.println( playersList[i].getPlayerName() +" rolled a " + diceValue +" and moved from "+ currentPosition+" to "+ newPosition);
                if(newPosition == 100){
                    System.out.println(playersList[i].getPlayerName() + " wins the game");
                    gameFinishes = true;
                    break;
                }
            }
            if(gameFinishes) break;
        }
    }
}