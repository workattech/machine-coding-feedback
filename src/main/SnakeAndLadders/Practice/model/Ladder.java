package SnakeAndLadders.Practice.model;

public class Ladder {
    private int startPos;
    private int endPos;

    public Ladder(int startPos, int endPos) {
        this.startPos = startPos;
        this.endPos = endPos;
    }

    public int getStartPos() {
        return startPos;
    }

    public void setStartPos(int startPos) {
        this.startPos = startPos;
    }

    public int getEndPos() {
        return endPos;
    }

    public void setEndPos(int endPos) {
        this.endPos = endPos;
    }
}
