package com.snake.and.ladder;

public class Ladder {
  private final int start;
  private final int end;

  Ladder(int s, int e) {
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
