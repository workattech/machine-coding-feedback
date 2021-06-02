package com.kbh.snl.models;

import java.util.UUID;

public class Player {
    private  String name;
    private int currentPosition;


  public Player(String name) {
    this.name = name;
    this.currentPosition = 0;
  }

  public int getCurrentPosition() {
    return currentPosition;
  }

  public void setCurrentPosition(int currentPosition) {
    this.currentPosition = currentPosition;
  }

  public String getName() {
    return name;
  }

  @Override
  public String toString() {
    return name;
  }
}
