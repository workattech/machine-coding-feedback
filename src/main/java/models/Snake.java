package models;

public class Snake {
    private final int head;
    private final int tail;

    public Snake(int head, int tail) {
        if(head <=0 || tail <=0 ) {
            throw new IllegalArgumentException("head or tail must be positive.");
        }
        if(head <= tail) {
            throw new IllegalArgumentException("head must be greater than tail.");
        }

        this.head = head;
        this.tail = tail;
    }

    public int getHead() {
        return head;
    }

    public int getTail() {
        return tail;
    }
}
