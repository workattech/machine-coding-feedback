package org.main;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

class SnakeAndLadderGameBoardPlayTest {

    @Test
    void startGame() throws FileNotFoundException, InterruptedException {
        String filepath = "C:\\Users\\mahes\\Exercism\\java\\SnakeAndLadder\\src\\main\\resources\\SankeAndLadderGameInput.txt";

        GameFilePathManager gameFilePathManager = new GameFilePathManager();
        gameFilePathManager.validateAndSetFilePath(filepath);
        Dice spyDice = spy(new Dice(2));

        GameBoard gameBoard = new SnakeAndLadderGameBoard(gameFilePathManager, spyDice, 120);
        SnakeAndLadderGameBoardLoader snakeAndLadderGameBoardLoader = new SnakeAndLadderGameBoardLoader(gameBoard);
        snakeAndLadderGameBoardLoader.LoadGameboard();
        SnakeAndLadderGamePlayers snakeAndLadderGamePlayers = new SnakeAndLadderGamePlayers();
        snakeAndLadderGamePlayers.LoadPlayers(snakeAndLadderGameBoardLoader.getSnakeAndLadderGamePlayersNames());
        SnakeAndLadderGameBoardPlay snakeAndLadderGameBoardPlay = new SnakeAndLadderGameBoardPlay((SnakeAndLadderGameBoard) gameBoard, snakeAndLadderGamePlayers);

        when(spyDice.rollDice()).thenReturn(12);
        snakeAndLadderGameBoardPlay.StartGame();
    }
}