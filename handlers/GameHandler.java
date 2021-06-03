package com.kbh.snl.handlers;

import com.kbh.snl.models.Game;
import com.kbh.snl.models.IntermediateObject;
import com.kbh.snl.models.Ladder;
import com.kbh.snl.models.Player;
import com.kbh.snl.models.Snake;
import com.kbh.snl.models.Dice;
import java.util.Iterator;

public class GameHandler {
  private static final int DEFAULT_BOARD_SIZE = 100;
  private final Game game;

  public GameHandler(final Game game) {
    this.game = game;
  }

  public void runGame() {
    while (game.getPlayersLeft().size() > 1) {
      final Iterator<Player> playerIterator = game.getPlayersLeft().iterator();
      executeNextStep(playerIterator);

    }
    System.out.println(String.format("%s wins the game", game.getSortedWinners()));
  }

  private void executeNextStep(Iterator<Player> playerIterator) {
    while (playerIterator.hasNext()) {
      final Player currentPlayer = playerIterator.next();

      //final int diceOutcome = this.throwdice();
     final int diceOutcome = Dice.rollDice();

      int newPosition = currentPlayer.getCurrentPosition() + diceOutcome;

      if (newPosition > game.getTotalCells()) {
        return;
      }

      if (game.getBoard().containsKey(newPosition)) {
        final IntermediateObject intermediateObject = game.getBoard().get(newPosition);
        if (intermediateObject instanceof Snake) {
          final Snake snake = (Snake) intermediateObject;
          newPosition = snake.getEndPosition();
        } else {
          final Ladder ladder = (Ladder) intermediateObject;
          newPosition = ladder.getEndPosition();
        }
      }

      System.out.println(String.format("%s rolled a %d and moved from %d to %d ", currentPlayer.getName(), diceOutcome, currentPlayer.getCurrentPosition(), newPosition));
      currentPlayer.setCurrentPosition(newPosition);

      if (newPosition == DEFAULT_BOARD_SIZE) {
        game.getSortedWinners().add(currentPlayer);
        playerIterator.remove();
      }

    }
  }
}
