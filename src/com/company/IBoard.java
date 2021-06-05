package com.company;

public interface IBoard {

  boolean isBoardFull();

  void printBoard();

  void setPiece(int row, int column, Players player);

  boolean checkHorizontalWin(Players player);

  boolean checkVerticalWin(Players player);

  boolean checkDiagonalWin(Players player);

  boolean checkValidMove(int row, int column, Players player);
}
