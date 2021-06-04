package main.java.models;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class GamePlayService {
  private GameBoard gameBoard = new GameBoard();

  public void setLadders(List<Ladder> ladders) {
    gameBoard.setLadders(ladders);
  }

  public void setSnakes(List<Snake> snakes) {
    gameBoard.setSnakes(snakes);
  }

  public void setPlayers(List<Player> players) {
    gameBoard.setPlayers(players);
  }

  public void setBoardSize(int size) {
    gameBoard.setSize(size);
  }


  private boolean isGameCompleted(Player currentPlayer) {
    if(currentPlayer.getCurrentPosition()==gameBoard.getSize()) {
      System.out.println( currentPlayer.getName() + " wins the game");
      return true;
    }
    return false;
  }

  private int currentPlayerGoingThroughSnakes(List<Snake>snakes, int currentPlayerFinalPosition) {
    for (int i = 0; i < snakes.size(); i++) {
      if (snakes.get(i).getHead() == currentPlayerFinalPosition) {
        currentPlayerFinalPosition = snakes.get(i).getTail();
        break;
      }
    }
    return currentPlayerFinalPosition;
  }

  private int currentPlayerGoingThroughLadders(List<Ladder>ladders, int currentPlayerFinalPosition) {
    for (int i = 0; i < ladders.size(); i++) {
      if (ladders.get(i).getStart() == currentPlayerFinalPosition) {
        currentPlayerFinalPosition = ladders.get(i).getEnd();
        break;
      }
    }
    return currentPlayerFinalPosition;
  }

  public void startGame() {

    List<Snake> snakes;
    List<Ladder> ladders;
    List<Player> playerQueue;
    snakes = gameBoard.getSnakes();
    ladders = gameBoard.getLadders();
    playerQueue = gameBoard.getPlayers();
    int currentPlayerFinalPosition = 0;

    while(true) {
      Player currentPlayer = playerQueue.get(0);
      playerQueue.remove(0);
      String currentPlayerName = currentPlayer.getName();


      int rollDiceResult = DiceRollService.roll();

      int currentPlayerInitialPosition = currentPlayer.getCurrentPosition();


      if((currentPlayerInitialPosition + rollDiceResult) < gameBoard.getSize()) {
        currentPlayerFinalPosition = currentPlayerInitialPosition + rollDiceResult;
      }

      int dummyCurrentPlayerInitialPosition = currentPlayerInitialPosition;


      while (true) {
        dummyCurrentPlayerInitialPosition = currentPlayerFinalPosition;

        currentPlayerFinalPosition = currentPlayerGoingThroughSnakes(snakes,currentPlayerFinalPosition);

        currentPlayerFinalPosition = currentPlayerGoingThroughLadders(ladders,currentPlayerFinalPosition);

        if(currentPlayerFinalPosition==dummyCurrentPlayerInitialPosition) {
          break;
        }

      }

      currentPlayer.setCurrentPosition(currentPlayerFinalPosition);

      System.out.println(currentPlayerName + " rolled a "+rollDiceResult+ " and moved from "+ (currentPlayerInitialPosition)+" to "+ currentPlayerFinalPosition);

      if(isGameCompleted(currentPlayer)) {
        break;
      }

      playerQueue.add(currentPlayer);

    }
  }







}
