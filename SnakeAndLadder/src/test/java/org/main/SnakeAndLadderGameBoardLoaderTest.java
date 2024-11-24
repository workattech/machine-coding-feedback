package org.main;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

class SnakeAndLadderGameBoardLoaderTest {

    @Test
    void loadGameboard() throws FileNotFoundException {
        GameFilePathManager gameFilePathManager = new GameFilePathManager();
        gameFilePathManager.validateAndSetFilePath("src/main/resources/SankeAndLadderGameInput.txt");
        GameBoard gameBoard = new SnakeAndLadderGameBoard(gameFilePathManager, new Dice(2), 120);
        SnakeAndLadderGameBoardLoader snakeAndLadderGameBoardLoader = new SnakeAndLadderGameBoardLoader(gameBoard);
        snakeAndLadderGameBoardLoader.LoadGameboard();
    }
}