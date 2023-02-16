package io.shaeli.machinecoding.snakeandladder.models;

import java.util.Random;

public class Dice {
    private int minVal;
    private int maxVal;

    private static Random randomizer;

    public Dice(int minVal, int maxVal) {
        this.minVal = minVal;
        this.maxVal = maxVal;
        randomizer = new Random(System.currentTimeMillis());
    }

    public int roll() {
        return randomizer.nextInt(minVal,maxVal);
    }
}
