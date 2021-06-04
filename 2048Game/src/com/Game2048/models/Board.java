package com.Game2048.models;

public class Board {

  private Tile[][] board;
  private int noOFGrid = 4;
  private int score = 0;

  public Board(){
    board = new Tile[noOFGrid][noOFGrid];
    for(int i = 0; i < board.length; i++){
      for(int j = 0; j < board[i].length; j++){
        board[i][j] = new Tile();
      }
    }
  }


  public Board(int grid){
    this.noOFGrid = grid;
    board = new Tile[noOFGrid][noOFGrid];
    for(int i = 0; i < board.length; i++){
      for(int j = 0; j < board[i].length; j++){
        board[i][j] = new Tile();
      }
    }
  }

  public int getScore() {
    return score;
  }

  public Tile[][] getBoard() {
    return board;
  }

  public int getRow(){
    return board.length;
  }

  public int getCol(){
    return board[0].length;
  }

  public void setBoardValue(int row, int col, String tileValue){
    board[row][col] = new Tile(tileValue);
  }

  public Tile getBoardValue(int row, int col){
    return board[row][col];
  }





}
