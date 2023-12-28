package src.snake_and_ladder;

import java.util.Random;

/**
 * Represents a Dice Roller
 * 
 * @param count is number of dices
 */
public class DiceRoller {
    private int count;
    Random random = new Random();

    public DiceRoller(int count) throws Exception {
        if (count < 1)
            throw new IllegalArgumentException("Atleast one dice should be there!");
        this.count = count;
    }

    /**
     * @return a random throw value
     */
    public int throwChance() {
        int totalThrow = 0;
        for (int i = 0; i < count; ++i) {
            totalThrow += getRandomValue();
        }
        return totalThrow;
    }

    private Integer getRandomValue() {
        return random.nextInt(6) + 1;
    }
}
