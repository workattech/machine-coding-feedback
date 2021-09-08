package com.workAtTech.snakeAndLadderApp;

import com.workAtTech.snakeAndLadderApp.model.Ladder;
import com.workAtTech.snakeAndLadderApp.model.Player;
import com.workAtTech.snakeAndLadderApp.model.Snake;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);

        int numOfSnakes = scanner.nextInt();
        // System.out.println("Rule 9 :Each snake will have its head at some number and its tail at a smaller number.");
        List<Snake> snakes = new ArrayList<Snake>();
        for (int i = 0; i < numOfSnakes; i++) {
            snakes.add(new Snake(scanner.nextInt(), scanner.nextInt()));
        }

        int noOfLadders = scanner.nextInt();
       // System.out.println("Rule 11 :Each ladder will have its start position at some number and end position at a larger number.");
        List<Ladder> ladders = new ArrayList<Ladder>();
        for (int i = 0; i < noOfLadders; i++) {
            ladders.add(new Ladder(scanner.nextInt(), scanner.nextInt()));
        }

        int noOfPlayers = scanner.nextInt();
        List<Player> players = new ArrayList<Player>();
        for (int i = 0; i < noOfPlayers; i++) {
            players.add(new Player(scanner.next()));
        }

        SnakeAndLadderAppLogic snakeAndLadderLogicObj = new SnakeAndLadderAppLogic();
        snakeAndLadderLogicObj.setPlayers(players);
        snakeAndLadderLogicObj.setSnakes(snakes);
        snakeAndLadderLogicObj.setLadders(ladders);
        snakeAndLadderLogicObj.startApp();
    }
}
