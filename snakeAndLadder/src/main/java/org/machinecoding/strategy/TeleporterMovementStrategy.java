package org.machinecoding.strategy;

import org.machinecoding.models.teleports.TeleporterEntity;

import java.util.List;

public class TeleporterMovementStrategy implements MovementStrategy {
    private final List<TeleporterEntity> teleports;

    public TeleporterMovementStrategy(List<TeleporterEntity> teleports) {
        this.teleports = teleports;
    }

    @Override
    public int move(int pos) {
        int currentPosition = pos;

        while (true) {
            boolean teleported = false;

            for (TeleporterEntity teleport : teleports) {
                if (teleport.canBeUsed(currentPosition)) {
                    currentPosition = teleport.teleport();
                    teleported = true;
                    break;
                }
            }

            if (!teleported) {
                break;
            }
        }

        return currentPosition;
    }

}
