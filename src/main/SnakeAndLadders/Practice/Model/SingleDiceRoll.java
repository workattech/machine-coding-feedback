package SnakeAndLadders.Practice.Model;

public class SingleDiceRoll implements Dice {
    private int min = 1;
    private int max = 6;

    @Override
    public int rollDice() {
        return (int)(Math.random()*(max-min+1)+min);
    }
}
