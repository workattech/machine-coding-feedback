package com.nirley.mock.dice;

public class Dice {

    private int min;
    private int max;
    private DiceMover diceMover;

    public Dice(int min, int max, DiceMover diceMover) {
        this.min = min;
        this.max = max;
        this.diceMover = diceMover;
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

    public int rollDice() {
        return diceMover.nextMove();
    }
}
