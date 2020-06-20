package com.games.snakesandladders;

import com.games.snakesandladders.props.Board;
import com.games.snakesandladders.props.Dice;

public class Game {
  private final Player[] players;
  private final Board board;
  private Player winner;

  public Game(Player[] players, Board board) {
    this.players = players;
    this.board = board;
  }

  public void play() {
    while (winner == null) {
      for (Player player : players) {
        int rolled = Dice.roll();
        int initialPosition = player.getPosition();
        int finalPosition = board.getFinalPosition(initialPosition, rolled);
        player.setPosition(finalPosition);
        if (board.isFinalCell(finalPosition)) {
          winner = player;
        }
        showTurnStats(player, rolled, initialPosition);
      }
    }
  }

  public Player getWinner() {
    return winner;
  }

  public void showTurnStats(Player player, int rolled, int initialPosition) {
    System.out.printf("%s rolled a %d and moved from %d to %d\n", player.getName(),
            rolled, initialPosition, player.getPosition());
  }
}
