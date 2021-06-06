package com.main.snakeandladder;

import com.main.snakeandladder.models.Ladder;
import com.main.snakeandladder.models.Player;
import com.main.snakeandladder.models.Snake;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SnakeLadderDriver {

  public static List<Snake> snakes = new ArrayList<>();
  public static List<Ladder> ladders = new ArrayList<>();
  public static List<Player> players = new ArrayList<>();

  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    SnakeLadderService snakeLadderService = new SnakeLadderService();
    int noOfSnakes = scanner.nextInt();
    getInputForSnakes(scanner, noOfSnakes);
    int noOfLadders = scanner.nextInt();
    getInputForLadders(scanner, noOfLadders);
    int noOfPlayers = scanner.nextInt();
    getInputForPlayers(scanner, noOfPlayers);
    snakeLadderService.setPlayerPieceSnakeLadder(players, snakes, ladders);
    snakeLadderService.startGame();
  }

  private static void getInputForPlayers(Scanner scanner, int noOfPlayers) {
    for (int playerNumber = 0; playerNumber < noOfPlayers; playerNumber++) {
      String playerName = scanner.next();
      Player player = new Player(playerName);
      players.add(player);
    }
  }

  private static void getInputForLadders(Scanner scanner, int noOfLadders) {
    for (int ladderNumber = 0; ladderNumber < noOfLadders; ladderNumber++) {
      int tail = scanner.nextInt();
      int head = scanner.nextInt();
      Ladder ladder = new Ladder(tail, head);
      ladders.add(ladder);
    }
  }

  private static void getInputForSnakes(Scanner scanner, int noOfSnakes) {
    for (int snakeNumber = 0; snakeNumber < noOfSnakes; snakeNumber++) {
      int head = scanner.nextInt();
      int tail = scanner.nextInt();
      Snake snake = new Snake(head, tail);
      snakes.add(snake);
    }
  }
}
