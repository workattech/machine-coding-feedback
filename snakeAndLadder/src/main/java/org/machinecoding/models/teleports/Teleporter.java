package org.machinecoding.models.teleports;

public interface Teleporter {
    boolean canBeUsed(int currentPosition);
    int teleport();
}
