package org.main;

import lombok.Getter;
import lombok.Setter;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

@Getter
@Setter
public class SnakeAndLadderGameBoardLoader implements LoadGameBoard{
    private GameBoard gameBoard;
    private Scanner gameBoardFileScanner;
    private ArrayList<String> snakeAndLadderGamePlayersNames;
    private SnakeAndLadderGameBoard snakeAndLadderGameBoard;

    public SnakeAndLadderGameBoardLoader(GameBoard gameBoard) {
        this.gameBoard = gameBoard;
        this.snakeAndLadderGamePlayersNames = new ArrayList<>();
    }

    private void readGameBoardFile() throws FileNotFoundException {
        snakeAndLadderGameBoard = (SnakeAndLadderGameBoard)(gameBoard);
        Path path = snakeAndLadderGameBoard.getGameFilePathManager().getFilePath();
        File file = new File(String.valueOf(path));
        gameBoardFileScanner = new Scanner(file);
    }

    private boolean checkIfGameBoardIsOfSnakeAndLadder() {
        return (gameBoard instanceof SnakeAndLadderGameBoard);
    }

    private void LoadSnakes(int numOfSnakes) {
        while (numOfSnakes > 0) {
            Integer snakeHead = gameBoardFileScanner.nextInt();
            Integer snakeTail = gameBoardFileScanner.nextInt();
            //System.out.println("Adding the snake with snakeHead "+snakeHead+" and snakeTail "+snakeTail);
            snakeAndLadderGameBoard.getSnakesMap().put(snakeHead, snakeTail);
            numOfSnakes--;
        }
    }

    private void LoadLadders(int numOfLadders) {
        while (numOfLadders > 0) {
            Integer ladderHead = gameBoardFileScanner.nextInt();
            Integer ladderTail = gameBoardFileScanner.nextInt();
            //System.out.println("Adding the snake with ladderHead "+ladderHead+" and ladderTail "+ladderTail);
            snakeAndLadderGameBoard.getLadderMap().put(ladderHead, ladderTail);
            numOfLadders--;
        }
    }

    private void LoadUsers(int numOfUsers) {
        gameBoardFileScanner.nextLine();
        while (numOfUsers > 0) {
            String name = gameBoardFileScanner.nextLine();
            //System.out.println("Adding a user with name "+name);
            snakeAndLadderGamePlayersNames.add(name);
            numOfUsers--;
        }
    }

    @Override
    public void LoadGameboard() throws FileNotFoundException {
        if (checkIfGameBoardIsOfSnakeAndLadder()) {
            readGameBoardFile();
            //Load snakes
            int numOfSnakes = gameBoardFileScanner.nextInt();
            //System.out.println("Number of Snakes for the game is  = "+ numOfSnakes);
            LoadSnakes(numOfSnakes);

            //Load Ladders
            int numOfLadders = gameBoardFileScanner.nextInt();
            //System.out.println("Number of Ladders for the game is  = "+ numOfLadders);
            LoadLadders(numOfLadders);

            //Load Users
            int numOfUsers = gameBoardFileScanner.nextInt();
            //System.out.println("Number of Users for the game is  = "+ numOfUsers);
            LoadUsers(numOfUsers);

            gameBoardFileScanner.close();
        } else {
            System.out.println("The Object Provided for the class"+ SnakeAndLadderGameBoardLoader.class +" is not of type "+ SnakeAndLadderGameBoard.class);
            System.exit(0);
        }
    }
}
