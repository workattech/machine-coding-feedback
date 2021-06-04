package com.Game2048.models;

public class Tile {

  private String tileValue;

  public Tile(){
    tileValue = "-";
  }

  public Tile(String tileValue){
    this.tileValue = tileValue;
  }

  public String getTileValue() {
    return tileValue;
  }


}
