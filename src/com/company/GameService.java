package com.company;

public class GameService {

  IBoard iBoard;
  int Row = 3;
  int Column = 3;

  public GameService() {
    this.iBoard = new Board(Row, Column);
  }

  public boolean nextMove(int row, int column, Players player) {

    iBoard.setPiece(row, column, player);
    iBoard.printBoard();
    if (iBoard.checkDiagonalWin(player)) {
      System.out.println(player.getName() + " won the game");
    }
    if (iBoard.checkHorizontalWin(player)) {
      System.out.println(player.getName() + " won the game");
    }
    if (iBoard.checkVerticalWin(player)) {
      System.out.println(player.getName() + " won the game");
    }
    return true;
  }

  public boolean isBoardFull() {
    return iBoard.isBoardFull();
  }

  public boolean checkValidMove(int row,int column,Players player){
    return iBoard.checkValidMove(row,column,player);
  }
}
