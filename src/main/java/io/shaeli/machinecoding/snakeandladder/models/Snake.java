package io.shaeli.machinecoding.snakeandladder.models;

public class Snake extends SpecialEntity {
    public Snake(int start, int end) {
        super(start, end);
        this.type = EntityType.SNAKE;
    }
}
