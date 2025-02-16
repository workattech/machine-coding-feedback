package models;

import lombok.Getter;

@Getter
public class Obstacles {
    final int start;
    final int end;

    public Obstacles(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }
}
