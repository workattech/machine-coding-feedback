import java.util.concurrent.ThreadLocalRandom;

public class Dice {
    private final int minValue;
    private final int maxValue;

    public Dice(int minValue, int maxValue) {
        this.minValue = minValue;
        this.maxValue = maxValue;
    }

    public int roll(int diceCount) {
       int totalValue = 0;
       while(diceCount > 0) {
           int value = ThreadLocalRandom.current().nextInt(maxValue - minValue) + 1;
           totalValue += value;
           diceCount--;
       }
       return totalValue;
    }
}
