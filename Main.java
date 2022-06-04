package com.kbh.snl;

import com.kbh.snl.handlers.GameHandler;
import com.kbh.snl.models.Game;
import com.kbh.snl.models.Ladder;
import com.kbh.snl.models.Player;
import com.kbh.snl.models.Snake;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    final List<Player> playersList = new ArrayList<>();
    final List<Snake> snakesList = new ArrayList<>();
    final List<Ladder> ladderList = new ArrayList<>();
    final int totalCells = 100;

    addtempInput(playersList, snakesList, ladderList);

    Game game = new Game(playersList, snakesList, ladderList, totalCells);
    GameHandler gameHandler = new GameHandler(game);
    gameHandler.runGame();

  }

  private static void addtempInput(final List<Player> players, final List<Snake> snakes,
      final List<Ladder> ladders) {
    Player player1 = new Player("Gaurav");
    Player player2 = new Player("Sagar");
    players.addAll(Arrays.asList(player1, player2));

    Snake snake1 = new Snake(25, 5);
    Snake snake2 = new Snake(10, 2);
    Snake snake3 = new Snake(45, 38);
    Snake snake4 = new Snake(80, 32);

    snakes.addAll(Arrays.asList(snake1, snake2, snake3, snake4));

    Ladder ladder1 = new Ladder(25, 5);
    Ladder ladder2 = new Ladder(25, 5);
    Ladder ladder3 = new Ladder(25, 5);
    Ladder ladder4 = new Ladder(25, 5);

    ladders.addAll(Arrays.asList(ladder1, ladder2, ladder3, ladder4));


  }

}
