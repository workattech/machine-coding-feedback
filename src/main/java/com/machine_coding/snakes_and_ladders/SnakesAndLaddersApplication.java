package com.machine_coding.snakes_and_ladders;

import com.machine_coding.snakes_and_ladders.entities.Board;
import com.machine_coding.snakes_and_ladders.entities.Ladder;
import com.machine_coding.snakes_and_ladders.entities.Player;
import com.machine_coding.snakes_and_ladders.entities.Snake;
import com.machine_coding.snakes_and_ladders.services.GameService;
import com.machine_coding.snakes_and_ladders.services.impl.GameServiceImpl;

import java.util.Scanner;

public class SnakesAndLaddersApplication {

    public static void main(String[] args){

        System.out.println("Application Started\n");

        Board board = new Board(1);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter size of board ");
        board.setSize(Integer.parseInt(scanner.nextLine()));
        System.out.println("Enter number of players ");
        int playerSize = Integer.parseInt(scanner.nextLine());
        if (playerSize > 0) {
            Player[] players = new Player[playerSize];
            System.out.println("Enter name of players ");
            for (int i = 0; i < playerSize; i++){
                players[i] = new Player(i + 1, scanner.nextLine(), board.getId());
            }
            board.setPlayers(players);
        } else return;
        System.out.println("Enter number of snakes ");
        int snakeSize = Integer.parseInt(scanner.nextLine());
        if (snakeSize > 0) {
            System.out.println("Enter head and tail of snakes ");
            Snake[] snakes = new Snake[snakeSize];
            for (int i = 0; i < snakeSize; i++){
                String[] headTail = scanner.nextLine().split(" ");
                snakes[i] = new Snake(i + 1, Integer.valueOf(headTail[0]), Integer.valueOf(headTail[1]), board.getId());
            }
            board.setSnakes(snakes);
        }

        System.out.println("Enter number of ladders ");
        int laddersSize = Integer.parseInt(scanner.nextLine());
        if (laddersSize > 0) {
            Ladder[] ladders = new Ladder[laddersSize];
            System.out.println("Enter top and down of ladders ");
            for (int i = 0; i < laddersSize; i++){
                String[] topDown = scanner.nextLine().split(" ");
                ladders[i] = new Ladder(i + 1, Integer.valueOf(topDown[0]), Integer.valueOf(topDown[1]), board.getId());
            }
            board.setLadders(ladders);
        }

        GameService gameService = new GameServiceImpl(board);
        gameService.runner();
        System.out.println("\nApplication Ended");
    }
}