package com.workattech.snakesandladders.game;

public class Dice {

    /**
     * only getters to be available for the variables as values will be initialized only once
     * while creating the object of Dice class
     */
    private int minValue;
    private int maxValue;
    private int initialDiceValue;

    public Dice(int minValue, int maxValue, int initialDiceValue) {
        this.minValue = minValue;
        this.maxValue = maxValue;
        this.initialDiceValue = initialDiceValue;
    }

    /**
     * @return a random int value between min and max value for dice
     * Eg - if we have one dice - min would be 1, max -6 , so below function would return a random int within
     * both the bounds inclusive
     * range is calculated as max-min+1  because if we used only max, we would get nums between 0 to 6(6 being non exclusive)
     * which would not serve the purpose. We need  nums between a range for that we need (value from round fn * max-min+1) + 1
     * so as to generate within a range
     * Why we did not do (Math.round * max-min) + min only for range ? - because this would generate nums till max-1
     * Eg for range 1-6 , say round fn return 0.9-> (int)(0.9 * (5-1)) +1-> (int)(3.6) + 1-> 3+1 ->4
     * so for this reason we need to add +1 in the range this would give our desired output
     * or a more simpler approach would be to use RandomUtils.nextInt(min, max+1) from apache lib
     */
    public int rollDice() {
        return (int) (Math.random() * (maxValue - minValue + 1)) + minValue;
    }
}