package com.workattech.snakesandladders.game;

import java.util.Scanner;

public class PlaySnakeLadderGame {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the board Size");
        int boardSize = sc.nextInt();
        System.out.println("Enter the number of Players");
        int numberOfPlayers = sc.nextInt();
        System.out.println("Enter the number of snakes");
        int numOfSnakes = sc.nextInt();
        System.out.println("Enter the number of ladders");
        int numOfLadders = sc.nextInt();
        Game game = new Game(numOfLadders, numOfSnakes, boardSize);
        for (int index = 0; index < numberOfPlayers; ++index) {
            System.out.println("Enter player name");
            String playerName = sc.next();
            Player player = new Player(playerName);
            game.addPlayer(player);
        }
        game.playSnakeLadderGame();
    }
}
