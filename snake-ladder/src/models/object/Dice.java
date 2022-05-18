package models.object;

import java.util.concurrent.ThreadLocalRandom;

public class Dice {
    public static Integer getDiceValue(Integer diceMinValue, Integer diceMaxValue) {
        int randomNum = ThreadLocalRandom.current().nextInt(diceMinValue, diceMaxValue + 1);
        return randomNum;
    }
}
