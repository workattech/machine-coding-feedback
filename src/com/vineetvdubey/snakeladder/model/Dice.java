package com.vineetvdubey.snakeladder.model;

import com.vineetvdubey.snakeladder.exception.InvalidBoardException;

import java.util.Random;

public class Dice {

    public final static int DEFAULT_DICE_COUNT = 1;
    private final static int RANDOM_MAX_BOUND = 6;

    private final int diceCount;
    private final Random random;

    protected Dice(int diceCount) {
        this.diceCount = diceCount;
        this.random = new Random(System.currentTimeMillis()); // seed value
    }

    protected Dice() {
        this(DEFAULT_DICE_COUNT);
    }

    public int roll() {
        int rollValue = 0;
        for (int i = 0; i < diceCount; i++) {
            rollValue = rollValue + getRand();
        }
        return rollValue;
    }

    /**
     * @return a random integer between 1 and 6 (both inclusive)
     */
    private int getRand() {
        return random.nextInt(RANDOM_MAX_BOUND) + 1;
    }

}
