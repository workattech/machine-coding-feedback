package com.ticTacToe;

import com.ticTacToe.model.Player;

import java.util.*;

public class Driver {
    private static final int DEFAULT_NUM_OF_PLAYERS = 2; //The game is played between two players.
    private static final int DEFAULT_MAX_MOVES = 9; // Total number of moves = 5(X) +4(O)
    private static final int DEFAULT_NUM_OF_COLUMNS = 3; // Grid is 3 * 3
    private static final int DEFAULT_NUM_OF_ROWS = 3; // Grid is 3 * 3

    public static void main(String[] args) {
        //Requirement : Ask the user for the names of the two players
        System.out.println("Please enter Piece and Name of players :");
        Scanner scanner = new Scanner(System.in);
        List<Player> playerList;
        playerList = new ArrayList<Player>();
        for (int i = 0; i < 2; i++) {
            playerList.add(new Player(scanner.next(), scanner.next())); //Adding Piece, Name to player
        }
        // Rule : The player with X makes the first turn. By any chance if user entered input with first player as a "O" then it will reverse the order of playerList to maintain moves order.
        List<Player> reversePlayerList = new ArrayList<>();
        if (playerList.get(0).getPiece().equals("O")) {
            ListIterator listIterator = playerList.listIterator(playerList.size());
            while (listIterator.hasPrevious()) {
                Player element = (Player) listIterator.previous();
                reversePlayerList.add(element);
            }
            playerList = reversePlayerList;
        }
        // Requirement : Print the grid after initializing
        GridService gridService = new GridService(DEFAULT_NUM_OF_ROWS, DEFAULT_NUM_OF_COLUMNS);

        //Requirement : Allow the user to make moves on behalf of both the players.
        while (true) {
            for (Player player : playerList) {
                try {
                    do {
                        if (gridService.isGameOver(DEFAULT_MAX_MOVES)) {
                            System.out.println("Game Over");
                            System.exit(0);
                        }
                    } while (!gridService.isMakeMovePossible(scanner.nextInt(), scanner.nextInt(), player.getPiece())); //Requirement : The user will make a move by entering the cell position.
                } catch (InputMismatchException e) {
                    System.exit(0);
                }
                if (gridService.isPlayerWinner(player.getPiece())) {
                    System.out.print(player.getName() + " won the game");
                    System.exit(0);
                }
            }
        }
    }
}
