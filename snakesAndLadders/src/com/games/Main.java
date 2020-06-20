package com.games;

import com.games.snakesandladders.Game;
import com.games.snakesandladders.Player;
import com.games.snakesandladders.props.Board;
import com.games.snakesandladders.props.Ladder;
import com.games.snakesandladders.props.Snake;

import java.util.Scanner;

public class Main {

    public static void main( String[] args )
    {
        Snake snakes[];
        Ladder ladders[];
        Player players[];
        Scanner scanner = new Scanner(System.in);

        snakes = inputSnakes(scanner);
        ladders = inputLadders(scanner);
        players = inputPlayers(scanner);

        Board board = new Board(snakes, ladders);
        Game game = new Game(players, board);
        game.play();
        showGameStats(game);
    }

    private static void showGameStats(Game game) {
        System.out.println(game.getWinner().getName() + " wins the game");
    }

    private static Player[] inputPlayers(Scanner scanner) {
        Player[] players;
        int numPlayers;
        numPlayers = scanner.nextInt();
        scanner.nextLine();
        players = new Player[numPlayers];
        for (int i=0; i<numPlayers; ++i) {
            String name = scanner.nextLine();
            Player player = new Player();
            player.setName(name);
            players[i] = player;
        }
        return players;
    }

    private static Ladder[] inputLadders(Scanner scanner) {
        Ladder[] ladders;
        int numLadders;
        numLadders = scanner.nextInt();
        ladders = new Ladder[numLadders];
        for (int i=0; i<numLadders; ++i) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            Ladder ladder = new Ladder();
            ladder.setStart(start);
            ladder.setEnd(end);
            ladders[i] = ladder;
        }
        return ladders;
    }

    private static Snake[] inputSnakes(Scanner scanner) {
        Snake[] snakes;
        int numSnakes;
        numSnakes = scanner.nextInt();
        snakes = new Snake[numSnakes];
        for (int i=0; i<numSnakes; ++i) {
            int head = scanner.nextInt();
            int tail = scanner.nextInt();
            Snake snake = new Snake();
            snake.setHead(head);
            snake.setTail(tail);
            snakes[i] = snake;
        }
        return snakes;
    }
}
