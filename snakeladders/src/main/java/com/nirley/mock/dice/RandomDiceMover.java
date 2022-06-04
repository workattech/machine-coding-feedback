package com.nirley.mock.dice;

import java.util.Random;

public class RandomDiceMover implements DiceMover {

    private int lowerBound;
    private int higherBound;
    private Random randomizer;

    public RandomDiceMover(int lowerBound, int higherBound) {
        this.higherBound = higherBound;
        this.lowerBound = lowerBound;
        this.randomizer = new Random();
    }

    @Override
    public int nextMove() {
        return randomizer.nextInt(higherBound - lowerBound) + lowerBound;
    }
}
