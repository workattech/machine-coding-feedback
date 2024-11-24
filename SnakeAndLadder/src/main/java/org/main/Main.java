package org.main;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, InterruptedException {

        System.out.println("Hello and welcome to the Snake and Ladder!");
        Scanner scanner = new Scanner(System.in);
        String filepath="";

        GameFilePathManager gameFilePathManager = new GameFilePathManager();
        while (!(gameFilePathManager.validateAndSetFilePath(filepath))) {
            System.out.println("Please give the valid game Loader file path");
            filepath = scanner.nextLine();
        }
        GameBoard gameBoard = new SnakeAndLadderGameBoard(gameFilePathManager, new Dice(2), 120);
        SnakeAndLadderGameBoardLoader snakeAndLadderGameBoardLoader = new SnakeAndLadderGameBoardLoader(gameBoard);
        snakeAndLadderGameBoardLoader.LoadGameboard();

        for(int i =0; i<1; i++) {
            SnakeAndLadderGamePlayers snakeAndLadderGamePlayers = new SnakeAndLadderGamePlayers();
            snakeAndLadderGamePlayers.LoadPlayers(snakeAndLadderGameBoardLoader.getSnakeAndLadderGamePlayersNames());
            SnakeAndLadderGameBoardPlay snakeAndLadderGameBoardPlay = new SnakeAndLadderGameBoardPlay((SnakeAndLadderGameBoard)gameBoard, snakeAndLadderGamePlayers);
            snakeAndLadderGameBoardPlay.StartGame();
            System.out.println("Thanks for playing the snake and ladder Game!!!!");
        }
    }
}