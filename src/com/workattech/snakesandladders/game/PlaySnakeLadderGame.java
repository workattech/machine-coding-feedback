package com.workattech.snakesandladders.game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PlaySnakeLadderGame {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the board Size");
        int boardSize = Integer.parseInt(br.readLine());
        System.out.println("Enter the number of Players");
        int numberOfPlayers = Integer.parseInt(br.readLine());
        System.out.println("Enter the number of snakes");
        int numOfSnakes = Integer.parseInt(br.readLine());
        List<Snake> snakesList = new ArrayList<>(numOfSnakes);
        System.out.printf("Enter %d pairs of snake head and tail respectively\n", numOfSnakes);
        for (int index = 0; index < numOfSnakes; ++index) {
            String[] snakeCombination = br.readLine().split("\\s+");
            int headOfSnake = Integer.parseInt(snakeCombination[0]);
            int tailOfSnake = Integer.parseInt(snakeCombination[1]);
            if (headOfSnake <= tailOfSnake || headOfSnake == 100) {
                System.out.println("Please enter the data again ,given head of snake is always greater than tail of snake and there can be no snake at 100");
                snakeCombination = br.readLine().split("\\s+");
                headOfSnake = Integer.parseInt(snakeCombination[0]);
                tailOfSnake = Integer.parseInt(snakeCombination[1]);
            }
            Snake snakeObj = new Snake(headOfSnake, tailOfSnake);
            snakesList.add(snakeObj);
        }

        System.out.println("Enter the number of ladders");
        int numOfLadders = Integer.parseInt(br.readLine());
        List<Ladder> laddersList = new ArrayList<>(numOfLadders);
        System.out.printf("Enter %d pairs of ladder head and tail respectively\n", numOfLadders);
        for (int index = 0; index < numOfLadders; ++index) {
            String[] ladderCombination = br.readLine().split("\\s+");
            int headOfLadder = Integer.parseInt(ladderCombination[0]);
            int tailOfLadder = Integer.parseInt(ladderCombination[1]);
            if (tailOfLadder <= headOfLadder) {
                System.out.println("Please enter the data again ,given tail of ladder is always greater than head of ladder");
                ladderCombination = br.readLine().split("\\s+");
                headOfLadder = Integer.parseInt(ladderCombination[0]);
                tailOfLadder = Integer.parseInt(ladderCombination[1]);
            }
            Ladder ladderObj = new Ladder(headOfLadder, tailOfLadder);
            laddersList.add(ladderObj);
        }

        Game game = new Game(snakesList, laddersList, boardSize);
        for (int index = 0; index < numberOfPlayers; ++index) {
            System.out.printf("Enter player %d name\n", (index + 1));
            String playerName = br.readLine();
            Player player = new Player(playerName);
            game.addPlayer(player);
        }
        game.printSnakesAndLaddersForBoard();
        game.playSnakeLadderGame();
    }
}
