package com.snake.and.ladder;

import java.util.List;

public class Game {

  public void initialize(List<Players> players, List<Snakes> snakes, List<Ladders> ladders) {
    boolean isEndTheGame = false;
    int lastPosition;

    while (!isEndTheGame) {
      // person.forEach((i)-> System.out.println(i.getName()));
      int roll;

      for (Players player : players) {

        roll = Utility.roll();

        lastPosition = player.getPosition();
        player.setPosition(player.getPosition() + roll);

        // check if there is snake
        CheckSnakeForCurrentPosition(snakes, player);

        // check if there is a ladder
        CheckLadderForCurrentPosition(ladders,player);

        if (player.getPosition() >= 100) {
          System.out.println(player.getName() + " wins the game");
          isEndTheGame = true;
          break;
        }

        System.out.println(
            player.getName() + " rolled a " + roll + " and moved from " + lastPosition
                + " to " + player.getPosition());
      }
    }
  }

  private void CheckLadderForCurrentPosition(List<Ladders> ladders, Players player) {
    for (Ladders ladder : ladders) {
      if (ladder.getStart() == player.getPosition()) {
        player.setPosition(ladder.getEnd());
      }
    }
  }

  private void CheckSnakeForCurrentPosition(List<Snakes> snakes, Players player) {
    for (Snakes snake : snakes) {
      if (snake.getStart() == player.getPosition()) {
        player.setPosition(snake.getEnd());
      }
    }
  }

}
