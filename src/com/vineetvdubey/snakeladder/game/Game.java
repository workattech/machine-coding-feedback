package com.vineetvdubey.snakeladder.game;

import com.vineetvdubey.snakeladder.model.Board;
import com.vineetvdubey.snakeladder.model.Dice;
import com.vineetvdubey.snakeladder.model.Player;

import java.util.Queue;

public class Game {

    private final Board board;
    private final Queue<Player> players;

    public Game(Board board, Queue<Player> players) {
        this.board = board;
        this.players = players;
    }

    public void play() {
        log("\nStarting a new game of Snakes and Ladders!\n");
        Dice dice = board.getDice();
        int finishPosition = 0;
        while (players.size() > 1) {
            Player currentPlayer = players.remove();
            int diceValue = dice.roll();
            int currPosition = currentPlayer.getPosition();
            int newPosition = board.calculateNewPosition(currPosition, diceValue);
            currentPlayer.setPosition(newPosition);
            logRollEvent(currentPlayer.getName(), diceValue, currPosition, newPosition);
            if (newPosition == board.getBoardSize()) {
                finishPosition += 1;
                logFinishEvent(currentPlayer.getName(), finishPosition);
            } else {
                players.add(currentPlayer);
            }
        }
        log("\nThanks for playing!");
    }

    private void logRollEvent(String name, int diceValue, int currPosition, int newPosition) {
        log(name + " rolled a " + diceValue + " and moved from " + currPosition + " to " + newPosition);
    }

    private void logFinishEvent(String name, int finishPosition) {
        log(name + " finished the game (rank " + finishPosition + ")");
    }

    private void log(String message) {
        System.out.println(message);
    }
}
