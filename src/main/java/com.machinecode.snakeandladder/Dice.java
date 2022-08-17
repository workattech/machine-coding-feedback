package com.machinecode.snakeandladder;

import java.util.Random;

public class Dice {
    private static final int DICE_MAX_VALUE = 6;
    private static final int DICE_MIN_VALUE = 1;
    int roll() {
        Random random = new Random();
        return random.nextInt(DICE_MAX_VALUE) + DICE_MIN_VALUE;
    }
}
