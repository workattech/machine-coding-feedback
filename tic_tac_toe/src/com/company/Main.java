package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        InputService inputService = InputService.getInstance();
        inputService.getInputs();
        GameService gameService = new GameService(inputService);

        gameService.showBoard();
        gameService.playGame();
    }
}
