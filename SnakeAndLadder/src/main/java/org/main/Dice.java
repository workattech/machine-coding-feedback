package org.main;

import lombok.Getter;
import lombok.Setter;

import java.util.Random;

/**
 *
 */
@Getter
@Setter
public class Dice {
    private Integer numOfDices;
    private Integer minDiceRollValue;
    private Integer maxDiceRollValue;

    public Dice(Integer numOfDices) {
        this.numOfDices = numOfDices;
        updateMinAndMaxDiceRollValues(numOfDices);
    }

    public void updateMinAndMaxDiceRollValues(Integer numOfDices) {
        minDiceRollValue = numOfDices;
        maxDiceRollValue = 6*numOfDices;
    }

    public int rollDice() {
        return getRandomNumberBetween(minDiceRollValue, maxDiceRollValue);
    }

    private int getRandomNumberBetween(int min, int max) throws IllegalArgumentException {
        if (max < min) {
            throw new IllegalArgumentException("Max value "+max+" should be less than min "+min);
        }
        Random r = new Random();
        return r.nextInt((max-min)+1)+min;
    }
}
