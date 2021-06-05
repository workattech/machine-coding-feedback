package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    takeInput();
  }

  private static void takeInput() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final int numberOfPlayers=2;
    Players[] players = new Players[2];
//    System.out.println("Enter the Player details: ");
    for (int i = 0; i < numberOfPlayers; i++) {
//      System.out.print("Enter player " + (i + 1) + " detail: ");
      String[] input = br.readLine().split(" ");
      players[i] = new Players(input[0], input[1]);
    }
    var gameService = new GameService();
    String[] input;
//    System.out.println("Enter the values: ");
    for (int i = 0; ; i++) {
      i = i % 2;
      String inputs = br.readLine();
      if (inputs.equals("exit")) {
        System.out.println("Game Over");
        break;
      } else {
        input = inputs.split(" ");
        int row = Integer.parseInt(input[0]) - 1;
        int column = Integer.parseInt(input[1]) - 1;

        if (gameService.isBoardFull()) {
          System.out.println("Game Over");
          break;
        }
        while (true) {
          if (gameService.checkValidMove(row, column, players[i])) {
            break;
          } else {
            System.out.println("Invalid Move");
            inputs = br.readLine();
            input = inputs.split(" ");
            row = Integer.parseInt(input[0]) - 1;
            column = Integer.parseInt(input[1]) - 1;
          }
        }
        gameService.nextMove(row, column, players[i]);
      }

    }


  }
}
