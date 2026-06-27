package snake_ladder;

import snake_ladder.behaviours.SimpleDiceRollBehaviour;
import snake_ladder.entities.Game;
import snake_ladder.entities.GameElement;
import snake_ladder.entities.Ladder;
import snake_ladder.entities.Player;
import snake_ladder.entities.Snake;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Main {

    private record GameConfig(Map<Integer, GameElement> gameElementMap, List<Player> players) {
    }

    private static GameConfig loadGameConfig(String inputPath) {
        Map<Integer, GameElement> gameElementMap = new HashMap<>();
        List<Player> players = new ArrayList<>();

        try (Scanner sc = new Scanner(new BufferedInputStream(new FileInputStream(inputPath)))) {
            int snakeCount = sc.nextInt();
            for (int i = 0; i < snakeCount; i++) {
                int head = sc.nextInt();
                int tail = sc.nextInt();
                gameElementMap.put(head, new Snake(head, tail));
            }

            int ladderCount = sc.nextInt();
            for (int i = 0; i < ladderCount; i++) {
                int start = sc.nextInt();
                int end = sc.nextInt();
                gameElementMap.put(start, new Ladder(start, end));
            }

            int playerCount = sc.nextInt();
            for (int i = 0; i < playerCount; i++) {
                String name = sc.next();
                players.add(new Player(name, 0));
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to read input file: " + inputPath, e);
        }

        return new GameConfig(gameElementMap, players);
    }


    public static void main(String[] args) {
        int gameSize = 100;

        String inputPath = args.length > 0 ? args[0] : "input/Input1.txt";
        GameConfig config = loadGameConfig(inputPath);
        Game game = new Game(gameSize, config.gameElementMap, config.players, new SimpleDiceRollBehaviour());

        Random randomNumber = new Random();
        int min = 1, max = 6;
        while (true) {
            for (Player player : config.players) {
                int diceRoll = randomNumber.nextInt(max - min + 1) + min;
                game.rollDice(player, diceRoll);

                if (player.getPosition() == gameSize) {
                    System.out.println(player.getName() + " wins the game");
                    return;
                }
            }
        }
    }
}
