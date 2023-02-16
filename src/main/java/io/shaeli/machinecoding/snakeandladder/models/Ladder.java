package io.shaeli.machinecoding.snakeandladder.models;

public class Ladder extends SpecialEntity {
    public Ladder(int start, int end) {
        super(start, end);
        this.type = EntityType.LADDER;
    }
}
