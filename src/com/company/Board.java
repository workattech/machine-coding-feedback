package com.company;

import java.util.Arrays;

public class Board implements IBoard {

  private final int Row;
  private final int Column;
  String[][] board;

  public Board(int row, int column) {
    Row = row;
    Column = column;
    board = new String[Row][Column];
    SetBoard(board);
  }

  private void SetBoard(String[][] board) {
    for (String[] arr:board){
      Arrays.fill(arr,"-");
    }
  }

  @Override
  public boolean isBoardFull() {
    for (int i = 0; i < Row; i++) {
      for (int j = 0; j < Column; j++) {
        if (board[i][j].equals("-")) {
          return false;
        }
      }
    }
    return true;
  }

  @Override
  public void printBoard() {
    for (int i = 0; i < Row; i++) {
      for (int j = 0; j < Column; j++) {
        System.out.print(board[i][j] + " ");
      }
      System.out.println();
    }
  }

  @Override
  public void setPiece(int row, int column, Players player) {
    board[row][column] = player.getPiece();
  }

  @Override
  public boolean checkHorizontalWin(Players player) {
    for (int i = 0; i < Row; i++) {
      int pieceCount = 0;
      for (int j = 0; j < Column; j++) {
        if (board[i][j].equals(player.getPiece())) {
          ++pieceCount;
        }
      }
      if (pieceCount == 3) {
        return true;
      }
    }
    return false;
  }

  @Override
  public boolean checkVerticalWin(Players player) {
    for (int i = 0; i < Row; i++) {
      int pieceCount = 0;
      for (int j = 0; j < Column; j++) {
        if (board[j][i].equals(player.getPiece())) {
          ++pieceCount;
        }
      }
      if (pieceCount == 3) {
        return true;
      }
    }
    return false;
  }

  @Override
  public boolean checkDiagonalWin(Players player) {
    int pieceCount = 0;
    for (int i = 0; i < Row; i++) {
      for (int j = 0; j < Column; j++) {
        if (i == j && board[j][i].equals(player.getPiece())) {
          ++pieceCount;
        }
      }
    }
    return 3 == pieceCount;
  }

  @Override
  public boolean checkValidMove(int row, int column, Players player) {
    return board[row][column].equals("-");
  }
}
