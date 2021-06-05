package com.company;

public class Players implements IPlayers {
  private final String Name;
  private final String Piece;

  public Players(String piece, String name) {
    Name = name;
    Piece = piece;
  }

  @Override
  public String getName() {
    return Name;
  }

  @Override
  public String getPiece() {
    return Piece;
  }
}
