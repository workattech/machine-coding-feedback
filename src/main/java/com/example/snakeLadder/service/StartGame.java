package com.example.snakeLadder.service;

import com.example.snakeLadder.model.Board;
import com.example.snakeLadder.model.Ladder;
import com.example.snakeLadder.model.Player;
import com.example.snakeLadder.model.Snake;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static com.example.snakeLadder.constants.Constants.DEFAULT_NO_OF_DICES;

@Service
public class StartGame {

    private Board snakeAndLadderBoard;
    private int initialNumberOfPlayers;
    private Queue<Player> players;
    private int noOfDices;
    private boolean shouldGameContinueTillLastPlayer;
    private boolean shouldAllowMultipleDiceRollOnSix;


    public StartGame(Board board, LinkedList<Player> playerList) {
        this.snakeAndLadderBoard = board;  //Optional Rule 2
        this.players = playerList;
        this.noOfDices = DEFAULT_NO_OF_DICES; //Optional
        this.initialNumberOfPlayers = board.getPlayerPositions().size();
    }


    public void setShouldGameContinueTillLastPlayer(boolean shouldGameContinueTillLastPlayer) {
        this.shouldGameContinueTillLastPlayer = shouldGameContinueTillLastPlayer;
    }

    public void setShouldAllowMultipleDiceRollOnSix(boolean shouldAllowMultipleDiceRollOnSix) {
        this.shouldAllowMultipleDiceRollOnSix = shouldAllowMultipleDiceRollOnSix;
    }

    private int getNewPositionAfterGoingThroughSnakesAndLadders(int newPosition) {
        int previousPosition;

        do {
            previousPosition = newPosition;
            for (Snake snake : snakeAndLadderBoard.getSnakes()) {
                if (snake.getSrc() == newPosition) {
                    newPosition = snake.getDest(); // Whenever a piece ends up at a position with the head of the snake, the piece should go down to the position of the tail of that snake.
                }
            }

            for (Ladder ladder : snakeAndLadderBoard.getLadders()) {
                if (ladder.getSrc() == newPosition) {
                    newPosition = ladder.getDest(); // Whenever a piece ends up at a position with the start of the ladder, the piece should go up to the position of the end of that ladder.
                }
            }
        } while (newPosition != previousPosition); // There could be another snake/ladder at the tail of the snake or the end position of the ladder and the piece should go up/down accordingly.
        return newPosition;
    }

    private void movePlayer(Player player, int positions) {
        int oldPosition = snakeAndLadderBoard.getPlayerPositions().get(player.getId());
        int newPosition = oldPosition + positions; // Based on the dice value, the player moves their piece forward that number of cells.

        int boardSize = snakeAndLadderBoard.getSize();

        if (newPosition > boardSize) {
            newPosition = oldPosition; // After the dice roll, if a piece is supposed to move outside position 100, it does not move.
        } else {
            newPosition = getNewPositionAfterGoingThroughSnakesAndLadders(newPosition);
        }

        snakeAndLadderBoard.getPlayerPositions().put(player.getId(), newPosition);
        System.out.println(player.getName() + " rolled a " + positions + " and moved from " + oldPosition + " to " + newPosition);
    }

    private boolean hasPlayerWon(Player player) {
        int playerPosition = snakeAndLadderBoard.getPlayerPositions().get(player.getId());
        int winningPosition = snakeAndLadderBoard.getSize();
        return playerPosition == winningPosition; // A player wins if it exactly reaches the position 100 and the game ends there.
    }

    private boolean isGameCompleted() {
        int currentNumberOfPlayers = players.size();
        return currentNumberOfPlayers < initialNumberOfPlayers;
    }

    private int getDiceValue (){
        int sum = 0;
        int temp = noOfDices;
        while(temp>0) {
            sum += DiceService.rollDice();
            temp--;
        }

        return sum;
    }

    public void run() {
        while (!isGameCompleted()) {
            int totalDiceValue = getDiceValue(); // Each player rolls the dice when their turn comes.
            Player currentPlayer = players.poll();
            movePlayer(currentPlayer, totalDiceValue);
            if (hasPlayerWon(currentPlayer)) {
                System.out.println(currentPlayer.getName() + " wins the game");
                snakeAndLadderBoard.getPlayerPositions().remove(currentPlayer.getId());
            } else {
                players.add(currentPlayer);
            }
        }
    }
}
