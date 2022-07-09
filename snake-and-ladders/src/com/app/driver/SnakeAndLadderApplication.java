package com.app.driver;

import com.app.models.*;

import java.util.*;

public class SnakeAndLadderApplication {
    private static Scanner sc = new Scanner(System.in);

    private static List<Jump> populateSnakesOrLadders()
    {
        int numberOfJumps = sc.nextInt();
        List<Jump> jumps =  new ArrayList<>();
        for (int i = 0; i <numberOfJumps ; i++) {
            int startPosition = sc.nextInt();
            int endPosition = sc.nextInt();
            jumps.add(new Jump(startPosition, endPosition));
        }
        return jumps;
    }

    public static void main(String[] args) {

        int boardSize =  sc.nextInt();

        int numberOfDies = sc.nextInt();

        int numberOfJumpItems = 0;
        List<Jump> snakePositions = populateSnakesOrLadders();
        List<Jump> ladderPositions = populateSnakesOrLadders();

        int numberOfPlayers = sc.nextInt();
        Deque<Player> players =  new ArrayDeque<>();
        for (int i = 0; i <numberOfPlayers ; i++) {
            String name = sc.next();
            players.add(new Player(name, 0));
        }

        Game game = new Game(boardSize, snakePositions, ladderPositions, numberOfDies, players);
        game.startGame();
    }
}
