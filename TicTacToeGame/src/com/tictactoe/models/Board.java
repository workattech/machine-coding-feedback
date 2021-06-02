package com.tictactoe.models;

public class Board {
  private static final int DEFAULT_BOARD_SIZE = 3;
  private char[][] board = new char[3][3];

  public char[][] getBoard() {
    return board;
  }

  public static int getDefaultBoardSize() {
    return DEFAULT_BOARD_SIZE;
  }

  public void setBoard(){
    for(int i = 0; i < 3; i++){
      for(int j = 0; j < 3; j++){
        board[i][j] = '-';
      }
    }
  }

}
