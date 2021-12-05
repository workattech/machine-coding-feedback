package com.workAtTech.snakeAndLadderApp.model;

/*
 ** Problem Statement : Number of snakes (s) followed by s lines each containing 2 numbers denoting the head and tail positions of the snake.
 */
public class Snake {
    private int head;
    private int tail;

    public Snake(int head, int tail) {
        this.head = head;
        this.tail = tail;
    }
    //Rule 9: Each snake will have its head at some number and its tail at a smaller number.
    public int getHead() {
        return head;
    }

    public int getTail() {
        return tail;
    }
}
