package org.machinecoding.models.teleports;

public class TeleporterEntity implements Teleporter {
    private final int startCell;
    private final int endCell;

    public TeleporterEntity(int startCell, int endCell){
        this.startCell = startCell;
        this.endCell = endCell;
    }

    @Override
    public boolean canBeUsed(int currentPosition) {
        return (startCell == currentPosition);
    }

    @Override
    public int teleport() {
        return endCell;
    }

    public int getStartCell() {
        return startCell;
    }

    public int getEndCell() {
        return endCell;
    }
}
