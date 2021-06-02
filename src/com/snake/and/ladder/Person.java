package com.snake.and.ladder;

public class Person {
  private int position;
  private final int id;
  private final String name;

  Person(String name) {
    this.name = name;
    id = Utility.getRandomNumber();
    position = 0;
  }

  public String getName() {
    return this.name;
  }

  public int getId() {
    return id;
  }

  public int getPosition() {
    return this.position;
  }

  public void setPosition(int position) {
    this.position = position;
  }
}
