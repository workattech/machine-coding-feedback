package com.game2048;

import com.game2048.models.Board;

import java.util.Scanner;

public class Driver {
    private static final int DEFAULT_NUM_OF_ROWS = 4;
    private static final int DEFAULT_NUM_OF_COLUMNS = 4;
    private static final int DEFAULT_WINNING_VALUE = 2048;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BoardManager boardManager = new BoardManager(DEFAULT_NUM_OF_ROWS, DEFAULT_NUM_OF_COLUMNS);
        boardManager.boardService.randomTileInsertor(Integer.toString(2));//Requirement : Initialize the game with two tiles numbered 2 at random positions.
        boardManager.boardService.randomTileInsertor(Integer.toString(2));
        boardManager.boardService.printBoard(); //Requirement : Print the board after initializing
        boolean isGameWon = false;
        boolean isGameOver = false;
        while (!isGameWon && !isGameOver) {
            int makeMoveValue = scanner.nextInt(); //Requirement : Allow the user to make moves.
            switch (makeMoveValue) {
                case 0:
                    boardManager.makeLeftDirectionMoves();
                    break;
                case 1:
                    boardManager.makeRightDirectionMoves();
                    break;
                case 2:
                    boardManager.makeTopDirectionMoves();
                    break;
                case 3:
                    boardManager.makeBottomDirectionMoves();
                    break;
                default:
                    System.out.println("Invalid Move");
            }
            boardManager.boardService.randomTileInsertor(Integer.toString(3)); // Rule : A random tile will be inserted at a random empty spot on the board after every move.
            boardManager.boardService.printBoard();
            isGameOver = boardManager.boardService.isGameOver();
            isGameWon = boardManager.boardService.isGameWon(DEFAULT_WINNING_VALUE);
        }
        if(isGameWon) {
            System.out.println("Congratulations");
        }
        if(isGameOver) {
            System.out.println("Game over");
        }
    }
}
