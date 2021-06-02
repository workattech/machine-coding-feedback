package com.kbh.snl.handlers;

import com.kbh.snl.models.Game;
import com.kbh.snl.models.IntermediateObject;
import com.kbh.snl.models.Ladder;
import com.kbh.snl.models.Player;
import com.kbh.snl.models.Snake;
import java.util.Iterator;
import java.util.Random;

public class GameHandler {

  private final Game game;
  private final Random randomNumberGenerator;

  public GameHandler(final Game game) {
    this.game = game;
    this.randomNumberGenerator = new Random();
  }

  public void rungame() {
    while (game.getPlayersLeft().size() > 1) {
      final Iterator<Player> playerIterator = game.getPlayersLeft().iterator();
      executeNextStep(playerIterator);

    }
    System.out.println(String.format("%s wins the game", game.getSortedWinners()));
  }

  private void executeNextStep(Iterator<Player> playerIterator) {
    while (playerIterator.hasNext()) {
      final Player currentPlayer = playerIterator.next();
      //throw dice
      final int diceOutcome = this.throwdice();
      //add current outcome to player position
      int newPosition = currentPlayer.getCurrentPosition() + diceOutcome;
      //if out of bounds then return else proceed
      if (newPosition > game.getTotalCells()) {
        return;
      }
      //check for ladders and snakes
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

      if (newPosition == 100) {
        game.getSortedWinners().add(currentPlayer);
        playerIterator.remove();
      }

    }
  }


  private int throwdice() {
    return randomNumberGenerator.nextInt(6) + 1;
  }
}
