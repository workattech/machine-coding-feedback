package com.main.snakeandladder.models;

public class Snake {
  int head;
  int tail;

  public Snake(int head, int tail) {
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
