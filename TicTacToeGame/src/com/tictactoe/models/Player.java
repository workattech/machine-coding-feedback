package com.tictactoe.models;

public class Player {
  private String name;
  private char pieceValue;

  public Player(char pieceValue,String name){
    this.name = name;
    this.pieceValue = pieceValue;
  }

  public String getName() {

    return name;
  }

  public void setName(String name) {

    this.name = name;
  }

  public char getPieceValue() {
    return pieceValue;
  }

  public void setPieceValue(char pieceValue) {
    this.pieceValue = pieceValue;
  }
}
