package services;

import models.Dice;

public class DiceService {
    final Dice dice;

    public DiceService(Dice dice) {
        this.dice = dice;
    }

    public int rollDice() {
        return (int)(Math.floor(Math.random() * dice.getUpperLimit())+ dice.getLowerLimit());
    }

}
