package com.machinecode.snakeandladder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final SnakeAndLadder snakeAndLadder = new SnakeAndLadder();

        Scanner sc = new Scanner(System.in);

        int snakeCount = sc.nextInt();
        HashMap<Integer, Integer> snakes = new HashMap<>();
        for (int i = 0; i < snakeCount; i++) {
            int startPos = sc.nextInt();
            int endPos = sc.nextInt();
            snakes.put(startPos, endPos);
        }
        snakeAndLadder.setSnakes(snakes);

        int ladderCount = sc.nextInt();
        HashMap<Integer, Integer> ladders = new HashMap<>();
        for (int i = 0; i < ladderCount; i++) {
            int startPos = sc.nextInt();
            int endPos = sc.nextInt();
            ladders.put(startPos, endPos);
        }
        snakeAndLadder.setLadders(ladders);

        int playerCount = sc.nextInt();
        List<Player> players = new ArrayList<>();
        for (int i = 0; i < playerCount; i++) {
            String name = sc.next();
            players.add(new Player(name, 0));
        }
        snakeAndLadder.setPlayer(players);

        snakeAndLadder.play();
    }
}
