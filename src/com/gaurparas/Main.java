package com.gaurparas;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String... args) {
        Scanner sc = new Scanner(System.in);

        //create new Board
        IJump[] board = new IJump[Utility.MAX_BOARD_NUMBER + 1];

        //Snakes
        fillSnakes(sc, board);

        //Ladders
        fillLadders(sc, board);

        //fill remaining board
        fillNoSnakeOrLadderBoard(board);

        //Players
        int TOTAL_PLAYERS = sc.nextInt();
        List<Player> playersList = new ArrayList<>();
        createPlayers(sc, playersList, TOTAL_PLAYERS);

        //Game Loop
        int turn = -1;
        while(true){
            turn = (turn + 1) % TOTAL_PLAYERS;
            Player currentPlayer = playersList.get(turn);
            int currentPosition = currentPlayer.getPosition();
            Random rand = new Random();
            int dice = rand.nextInt(Utility.MAX_DICE_NUMBER) + 1;
            int toPosition = currentPosition + dice;
            if(toPosition>Utility.MAX_BOARD_NUMBER) {
                System.out.println(currentPlayer.getName() + " rolled a " + dice +
                        " but can not move from " + currentPosition);
                continue;
            }
            while(toPosition != board[toPosition].jumpTo()) {
                toPosition = board[toPosition].jumpTo();
            }
            currentPlayer.setPosition(toPosition);
            System.out.println(currentPlayer.getName() + " rolled a " + dice +
                    " and moved from " + currentPosition + " to " + toPosition);
            if(toPosition==Utility.MAX_BOARD_NUMBER){
                System.out.println(currentPlayer.getName() + " wins the game");
                break;
            }
        }
    }

    private static void createPlayers(Scanner sc, List<Player> playersList, int total_players) {
        for (int i = 0; i < total_players; i++) {
            String name = sc.next();
            playersList.add(new Player(name, 0));
        }
    }

    private static void fillSnakes(Scanner sc, IJump[] board) {
        int s = sc.nextInt();
        for (int i = 0; i < s; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            board[start] = new Snake(start, end);
        }
    }

    private static void fillLadders(Scanner sc, IJump[] board) {
        int l = sc.nextInt();
        for (int i = 0; i < l; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            board[start] = new Ladder(start, end);
        }
    }

    private static void fillNoSnakeOrLadderBoard(IJump[] board) {
        for (int i = 1; i <= Utility.MAX_BOARD_NUMBER; i++) {
            if (board[i] == null)
                board[i] = new NoSnakeOrLadder(i, i);
        }
    }
}
