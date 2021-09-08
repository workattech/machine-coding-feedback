package com.workAtTech.snakeAndLadderApp;

import java.util.Random;

/*
 ** Rule 2 : The game will have a six sided dice numbered from 1 to 6 and will always give a random number on rolling it.
 */
public class DiceRoll {
    private final static int RANDOM_MIN_BOUND = 1;
    private final static int RANDOM_MAX_BOUND = 6;
    public int roll() {
        return new Random().nextInt(RANDOM_MAX_BOUND) + RANDOM_MIN_BOUND;
    }
}