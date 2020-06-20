package com.games.snakesandladders;

public class Player {
  private int position = 0;

  private String name;

  public int getPosition() {
    return this.position;
  }

  public void setPosition(int position) {
    this.position = position;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
