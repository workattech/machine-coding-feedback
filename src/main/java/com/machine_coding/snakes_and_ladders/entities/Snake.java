package com.machine_coding.snakes_and_ladders.entities;

public class Snake extends Entity {

    private int head;
    private int tail;
    private Integer boardId;

    public Snake(Integer id, Integer head, Integer tail, Integer boardId) {
        super(id);
        this.head = head;
        this.tail = tail;
        this.boardId = boardId;
    }

    public Integer getHead() {
        return head;
    }

    public void setHead(Integer head) {
        this.head = head;
    }

    public Integer getTail() {
        return tail;
    }

    public void setTail(Integer tail) {
        this.tail = tail;
    }
}