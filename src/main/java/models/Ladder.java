package models;

public class Ladder {
    private final int start;
    private final int end;

    public Ladder(int start, int end) {
        if(start <= 0 || end <= 0) {
            throw new IllegalArgumentException("start or end muse positive");
        }
        if(start>=end) {
            throw new IllegalArgumentException("start must be less than end");
        }

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
