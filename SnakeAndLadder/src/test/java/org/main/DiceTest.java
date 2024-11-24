package org.main;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DiceTest {
    public boolean isBetween(int min, int max, int val) {
        return (val <= max && val >=min);
    }

    @Test
    public void testRollDice() {
        final int numOfDices = 2;
        int diceVal;
        Dice dice = new Dice(numOfDices);

        //Test the Random generator used in Dice class
        for (int i=0; i < 100; i++) {
            diceVal = dice.rollDice();
            System.out.println("Dice Val is "+diceVal);
            assertTrue(isBetween(dice.getMinDiceRollValue(), dice.getMaxDiceRollValue(), diceVal), "Val Produced "+ dice.getMinDiceRollValue()+" is in range 1 and "+dice.getMaxDiceRollValue());
        }
    }

}