package models;

import lombok.Getter;

@Getter
public class Dice {
    int lowerLimit;
    int upperLimit;

    public Dice() {
        this.lowerLimit = 1;
        this.upperLimit = 6;
    }

    public Dice(int upperLimit) {
        this.lowerLimit = 1;
        this.upperLimit = upperLimit;
    }

    Dice(int lowerLimit, int upperLimit) {
        this.lowerLimit = lowerLimit;
        this.upperLimit = upperLimit;
    }

    public int getLowerLimit() {
        return lowerLimit;
    }

    public void setLowerLimit(int lowerLimit) {
        this.lowerLimit = lowerLimit;
    }

    public int getUpperLimit() {
        return upperLimit;
    }

    public void setUpperLimit(int upperLimit) {
        this.upperLimit = upperLimit;
    }
}
