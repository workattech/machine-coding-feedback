package org.machinecoding.strategy;

import org.machinecoding.models.Dice;

import java.util.List;

public class DiceMovementStrategy implements MovementStrategy {
    private final List<Dice> dices;

    public DiceMovementStrategy(List<Dice> dices) {
        this.dices = dices;
    }

    @Override
    public int move(int pos) {
        int steps = 0;
        for (Dice dice : dices) {
            steps += dice.roll();
        }
        return pos + steps;
    }
}
