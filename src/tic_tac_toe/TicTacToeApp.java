package src.tic_tac_toe;

import java.util.*;

public class TicTacToeApp {
    private Board board;
    private Player player1;
    private Player player2;
    private Scanner scan = new Scanner(System.in);

    public TicTacToeApp() {
        board = new Board(3);
        String[] input;
        // Assuming two players are given in input
        if (scan.hasNextLine()) {
            input = scan.nextLine().split(" ");
            // System.out.println(player1Input[1] + " " + player1Input[0]);
            this.player1 = new Player(input[1], input[0]);
        }
        if (scan.hasNextLine()) {
            input = scan.nextLine().split(" ");
            // System.out.println(player2Input[1] + " " + player2Input[0]);
            this.player2 = new Player(input[1], input[0]);
        }
    }

    public void run() {
        board.printBoard();
        boolean isFirstPlayerTurn = true;
        while (scan.hasNextLine()) {
            int x, y;
            String[] input = scan.nextLine().split(" ");
            if (input[0].equals("exit")) {
                break;
            }
            x = Integer.parseInt(input[0]);
            y = Integer.parseInt(input[1]);
            // System.out.println(isFirstPlayerTurn + " " + x + " " + y);
            if (isFirstPlayerTurn) {
                if (board.playChance(x, y, player1)) {
                    if (board.isBoardSolved()) {
                        System.out.println(player1.getName() + " won the game");
                        break;
                    } else if (board.isGameOver()) {
                        System.out.println("Game Over");
                        break;
                    }
                    isFirstPlayerTurn = !isFirstPlayerTurn;
                } else {
                    System.out.println("Invalid Move");
                }
            } else {
                if (board.playChance(x, y, player2)) {
                    if (board.isBoardSolved()) {
                        System.out.println(player2.getName() + " won the game");
                        break;
                    } else if (board.isGameOver()) {
                        System.out.println("Game Over");
                        break;
                    }
                    isFirstPlayerTurn = !isFirstPlayerTurn;
                } else {
                    System.out.println("Invalid Move");
                }
            }
        }
        scan.close();
    }

}
