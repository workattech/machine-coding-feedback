package com.snake.and.ladder;

public class Snake {
    private final int start;
    private final int end;

    Snake(int s, int e) {
      this.start = s;
      this.end = e;
    }
    public int getStart() {
      return start;
    }

    public int getEnd() {
      return end;
    }
  }
