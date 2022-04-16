package Models;

public class Snake {
    private int head, tail;
    public Snake(int head, int tail) {
        this.head = head;
        this.tail = tail;
    }

    public int getHead() {
        return this.head;
    }

    public int getTail() {
        return this.tail;
    }
}