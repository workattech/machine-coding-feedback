package com.app.driver;

import com.app.models.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SnakeAndLadderApplication {

    public static void main(String[] args) {
        int boardSize=100,numberOfFaces=6,numberOfDies=1;
        Scanner sc = new Scanner(System.in);

        int numberOfSnakes = sc.nextInt();
        List<Snake> snakes =  new ArrayList<>();
        for (int i = 0; i <numberOfSnakes ; i++) {
            int startPosition = sc.nextInt();
            int endPosition = sc.nextInt();
            snakes.add(new Snake(startPosition, endPosition));
        }

        int numberOfladders = sc.nextInt();
        List<Ladder> ladders =  new ArrayList<>();
        for (int i = 0; i <numberOfladders ; i++) {
            int startPosition = sc.nextInt();
            int endPosition = sc.nextInt();
            ladders.add(new Ladder(startPosition, endPosition));
        }

        int numberOfPlayers = sc.nextInt();
        List<Player> players =  new ArrayList<>();
        for (int i = 0; i <numberOfPlayers ; i++) {
            String name = sc.next();
            players.add(new Player(name, 0));
        }

        Board board = new Board(boardSize, snakes, ladders);
        Die die = new Die(0, numberOfFaces, numberOfDies);

        System.out.println("Start");
        while (true) {
            int winners = 0;
            for (int i = 0; i <numberOfPlayers ; i++) {
                Player player =  players.get(i);
                player.makeMove(die);
                int newPosition = board.updatePlayerPosition(player.getCurrentPosition(), die.getCurrentFace());

                System.out.println(player.getName()+" rolled a "+die.getCurrentFace()+" and moved from "+player.getCurrentPosition()+" to "+newPosition);

                player.setCurrentPosition(newPosition);
                if (player.checkWinner(board))
                {
                    winners++;
                    System.out.println(player.getName()+" wins  the Game! with rank "+winners);
                    break;
                }
            }
            if (winners == numberOfPlayers-1)
            {
                System.out.println("END");
                break;
            }
        }
    }
}
