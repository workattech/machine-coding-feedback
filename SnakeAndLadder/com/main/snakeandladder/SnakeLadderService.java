package com.main.snakeandladder;

import com.main.snakeandladder.models.Ladder;
import com.main.snakeandladder.models.Player;
import com.main.snakeandladder.models.Snake;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Random;

public class SnakeLadderService {
  public static final int DICE_VALUES  = 6;
  public static final int INITIAL_PLAYER_POSITION = 0;
  int initialNumberOfPlayers;
  Queue<Player> playerSequence = new LinkedList<>();
  SnakeLadderBoard snakeLadderBoard  = new SnakeLadderBoard();

  public void setPlayerPieceSnakeLadder(List<Player> players, List<Snake> snakes, List<Ladder> ladders) {
    initialNumberOfPlayers = players.size();
    Map<Player, Integer> playerPiece = new HashMap<>();
    for (Player player : players) {
      playerSequence.add(player);
      playerPiece.put(player, INITIAL_PLAYER_POSITION);
    }
    snakeLadderBoard.setPlayerPiece(playerPiece);
    snakeLadderBoard.setSnakes(snakes);
    snakeLadderBoard.setLadders(ladders);
  }
  int diceRoll(){
    return new Random().nextInt(DICE_VALUES) + 1;
  }
  boolean isGameComplete(){
    if(initialNumberOfPlayers > playerSequence.size()){
      return true;
    }
    else{
      return false;
    }
  }
  int getNewPosition(int newPosition){
    int previousPosition;
    do{
      previousPosition = newPosition;
      for(Snake snake : snakeLadderBoard.getSnakes()){
        if(snake.getHead() == newPosition){
          newPosition = snake.getTail();
        }
      }
      for(Ladder ladder : snakeLadderBoard.getLadders()){
        if(ladder.getTail() == newPosition){
          newPosition = ladder.getHead();
        }
      }
    }while(newPosition != previousPosition);
    return  newPosition;
  }
  void movePlayer(Player player, int diceRolledNumber){
    int oldPosition = snakeLadderBoard.getPlayerPiece().get(player);
    int newPosition = oldPosition + diceRolledNumber;
    int boardSize = snakeLadderBoard.getBoardSize();
    if(newPosition > boardSize){
      newPosition = oldPosition;
    }
    else{
      newPosition = getNewPosition(newPosition);
    }
    snakeLadderBoard.getPlayerPiece().put(player, newPosition);
    System.out.println(player.getName()  + " rolled a " + diceRolledNumber + " and moved from " + oldPosition + " to " + newPosition);

  }
  boolean hasPlayerWon(Player players){
    if(snakeLadderBoard.getPlayerPiece().get(players) == snakeLadderBoard.getBoardSize()){
      return true;
    }
    return false;
  }
  void startGame(){
    while(!isGameComplete()){
      int diceRollValue = diceRoll();
      Player currentPlayer = playerSequence.poll();
      movePlayer(currentPlayer, diceRollValue);
      if(hasPlayerWon(currentPlayer)){
        System.out.println(currentPlayer.getName() + " wins the game");
      }
      else{
        playerSequence.add(currentPlayer);
      }
    }
  }
}

