package SnakeAndLadders.Practice.model;

public class Snake {
    private int startPos;
    private int end_pos;

    public Snake(int startPos, int end_pos) {
        this.startPos = startPos;
        this.end_pos = end_pos;
    }

    public int getStartPos() {
        return startPos;
    }

    public void setStartPos(int startPos) {
        this.startPos = startPos;
    }

    public int getEnd_pos() {
        return end_pos;
    }

    public void setEnd_pos(int end_pos) {
        this.end_pos = end_pos;
    }
}
