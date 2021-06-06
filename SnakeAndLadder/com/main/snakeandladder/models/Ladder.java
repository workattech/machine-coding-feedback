package com.main.snakeandladder.models;

public class Ladder {
  int head;
  int tail;

  public Ladder(int tail, int head) {
    this.head = head;
    this.tail = tail;
  }

  public int getHead() {
    return head;
  }

  public void setHead(int head) {
    this.head = head;
  }

  public int getTail() {
    return tail;
  }

  public void setTail(int tail) {
    this.tail = tail;
  }
}
