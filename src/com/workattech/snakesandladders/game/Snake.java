package com.workattech.snakesandladders.game;

public class Snake {

    private int snakeHead;
    private int snakeTail;

    public Snake(int snakeHead, int snakeTail) {
        this.snakeHead = snakeHead;
        this.snakeTail = snakeTail;
    }

    public int getSnakeHead() {
        return snakeHead;
    }

    public int getSnakeTail() {
        return snakeTail;
    }
}


