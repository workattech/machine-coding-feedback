package com.vineetvdubey.snakeladder.model;

import com.vineetvdubey.snakeladder.exception.InvalidBoardException;

import java.util.Collections;
import java.util.Map;

public class Board {

    public static final int DEFAULT_BOARD_SIZE = 100;
    public static final int DEFAULT_DICE_COUNT = 1;

    private final int size;
    private final int diceCount;
    private final Dice dice;
    private final Map<Integer, Integer> snakes;
    private final Map<Integer, Integer> ladders;

    public Board(int size, Map<Integer, Integer> snakes, Map<Integer, Integer> ladders, int diceCount) throws InvalidBoardException {
        this.size = size;
        this.diceCount = diceCount;
        this.dice = new Dice(diceCount);
        this.snakes = snakes != null ? snakes : Collections.emptyMap();
        this.ladders = ladders != null ? ladders : Collections.emptyMap();
        validateBoard();
    }

    public Board(Map<Integer, Integer> snakes, Map<Integer, Integer> ladders) throws InvalidBoardException {
        this(DEFAULT_BOARD_SIZE, snakes, ladders, DEFAULT_DICE_COUNT);
    }

    public Board(int size, Map<Integer, Integer> snakes, Map<Integer, Integer> ladders) throws InvalidBoardException {
        this(size, snakes, ladders, DEFAULT_DICE_COUNT);
    }

    public Board(Map<Integer, Integer> snakes, Map<Integer, Integer> ladders, int diceCount) throws InvalidBoardException {
        this(DEFAULT_BOARD_SIZE, snakes, ladders, diceCount);
    }

    public int getBoardSize() {
        return this.size;
    }

    public int getDiceCount() {
        return this.diceCount;
    }

    public Dice getDice() {
        return this.dice;
    }

    private void validateBoard() throws InvalidBoardException {
        if (size <= 0) {
            throw new InvalidBoardException("Board size has to be 1 or greater.");
        }
        if (diceCount < 1) {
            throw new InvalidBoardException("Need at least 1 die to play");
        }
        if (diceCount > 2) {
            throw new InvalidBoardException("Too many dice, use either 1 or 2 dice");
        }
    }

    public int calculateNewPosition(int currentPosition, int diceValue) {
        int newPos = currentPosition + diceValue;
        if (newPos > size) { //newPos cannot be more than size of board
            if (diceCount > 1 && currentPosition > size - diceCount && diceValue == diceCount) {
                // handles edge case - e.g. unable to get diceValue 1 due to 2 dice
                return size;
            }
            return currentPosition;
        }
        if (snakes.containsKey(newPos)) {
            newPos = snakes.get(newPos);
            return calculateNewPosition(newPos, 0); //verify if there is another snake at the end
        }
        if (ladders.containsKey(newPos)) {
            newPos = ladders.get(newPos);
            return calculateNewPosition(newPos, 0); //verify if there is another ladder at the top
        }
        return newPos;
    }

}
