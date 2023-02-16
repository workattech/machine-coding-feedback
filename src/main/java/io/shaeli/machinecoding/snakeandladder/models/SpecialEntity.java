package io.shaeli.machinecoding.snakeandladder.models;

public abstract class SpecialEntity {
    private int start;
    private int end;
    protected EntityType type;

    public SpecialEntity(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return this.start;
    }

    public int getEnd() {
        return this.end;
    }

}
