package com.vineetvdubey.snakeladder;

import com.vineetvdubey.snakeladder.exception.InvalidBoardException;
import com.vineetvdubey.snakeladder.game.Game;
import com.vineetvdubey.snakeladder.model.Board;
import com.vineetvdubey.snakeladder.model.Player;

import java.util.*;

public class Main {

    public static void main(String[] args) throws InvalidBoardException {
        Scanner sc = new Scanner(System.in);

        int boardSize = sc.nextInt();
        int diceCount = sc.nextInt();

        int snakesCount = sc.nextInt();
        Map<Integer, Integer> snakes = new HashMap<>();
        for (int i = 0; i < snakesCount; i++) {
            snakes.put(sc.nextInt(), sc.nextInt());
        }

        int laddersCount = sc.nextInt();
        Map<Integer, Integer> ladders = new HashMap<>();
        for (int i = 0; i < laddersCount; i++) {
            ladders.put(sc.nextInt(), sc.nextInt());
        }

        int playersCount = sc.nextInt();
        sc.nextLine(); //consume EOL
        Queue<Player> players = new LinkedList<>();
        for (int i = 0; i < playersCount; i++) {
            players.add(new Player(sc.nextLine()));
        }


        Board board = new Board(boardSize, snakes, ladders, diceCount);
        Game game = new Game(board, players);
        game.play();
    }
}
