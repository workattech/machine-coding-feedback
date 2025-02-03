package org.machinecoding.strategy;

public class GameMovementStrategy implements MovementStrategy {
    final DiceMovementStrategy diceMovementStrategy;
    final TeleporterMovementStrategy teleporterMovementStrategy;

    private int diceValue = 0;
    private int teleporterValue = 0;

    public GameMovementStrategy(DiceMovementStrategy diceMovementStrategy,
                         TeleporterMovementStrategy teleporterMovementStrategy) {
        this.diceMovementStrategy = diceMovementStrategy;
        this.teleporterMovementStrategy = teleporterMovementStrategy;
    }

    @Override
    public int move(int pos) {
        int diceMovedPosition = diceMovementStrategy.move(pos);
        this.diceValue = diceMovedPosition - pos;

        int teleporterMovedPosition = teleporterMovementStrategy.move(diceMovedPosition);
        this.teleporterValue = teleporterMovedPosition - diceMovedPosition;

        return teleporterMovedPosition;
    }

    public int getDiceValue() {
        return diceValue;
    }
    public int getTeleporterValue() {
        return teleporterValue;
    }

}
