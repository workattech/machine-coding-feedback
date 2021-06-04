package main.java.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Driver {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    List<Snake> snakes =new ArrayList<>();
    List<Ladder> ladders =new ArrayList<>();
    List<Player> players =new ArrayList<>();

    int noOfSnakes = sc.nextInt();
    for(int i=0;i<noOfSnakes;i++) {
      Snake snake = new Snake();
      snake.setHead(sc.nextInt());
      snake.setTail(sc.nextInt());
      snakes.add(snake);
    }

    int noOfLadders = sc.nextInt();
    for(int i=0;i<noOfLadders;i++) {
      Ladder ladder = new Ladder();
      ladder.setStart(sc.nextInt());
      ladder.setEnd(sc.nextInt());
      ladders.add(ladder);
    }

    int noOfPlayers = sc.nextInt();
    for(int i=0;i<noOfPlayers;i++) {
      Player player = new Player();
      player.setName(sc.next());
      player.setCurrentPosition(0);
      players.add(player);
    }

    GamePlayService gamePlayService = new GamePlayService();
    gamePlayService.setPlayers(players);
    gamePlayService.setSnakes(snakes);
    gamePlayService.setLadders(ladders);
    gamePlayService.setBoardSize(100);
    gamePlayService.startGame();
  }


}
