package com.tictactoe;

import com.tictactoe.models.Board;
import com.tictactoe.models.Player;
import com.tictactoe.models.Move;
import java.util.List;


public class GameEngine {

  private List<Player> players; //Option 2 Allow more than 2 players/piece types
  private boolean isGameCompleted;
  private List<Move> moves;
  private static final int DEFAULT_BOARD_SIZE = 3;
  private char[][] board = new char[DEFAULT_BOARD_SIZE][DEFAULT_BOARD_SIZE];
  private boolean playerX = true;

  public GameEngine(){
    this.isGameCompleted = false;
  }

  private void initialiseBoard(){
    for(int row = 0; row < DEFAULT_BOARD_SIZE; row++){
      for(int col = 0; col < DEFAULT_BOARD_SIZE; col++){
        board[row][col] = '-';
      }
    }
  }

  private void displayBoard(){
    for(int row = 0; row < DEFAULT_BOARD_SIZE; row++){
      for(int col = 0; col < DEFAULT_BOARD_SIZE; col++){
       System.out.print(board[row][col]+"  ");
      }
      System.out.println();
    }
  }

  public List<Player> getPlayers() {
    return players;
  }

  public void setPlayers(List<Player> players) {
    this.players = players;
  }

  public List<Move> getMoves() {
    return moves;
  }

  public void setMoves(List<Move> moves) {
    this.moves = moves;
  }

  private boolean isValidMove(int row, int col){
    if(row < 0 || col < 0 || row > 2 || col > 2)
      return false;
    else if (board[row][col] != '-')
      return false;
    else
      return true;
  }

  private boolean hasPlayerWonTheGame(){
    //Check each row
    for(int row = 0; row < 3; row++){
      if(board[row][0] == board[row][1] && board[row][1] == board[row][2] && board[row][0] != '-')
        return true;
    }

    //Check each column
    for(int col = 0; col < 3; col++){
      if(board[0][col] == board[1][col] && board[1][col] == board[2][col] && board[0][col] != '-')
        return true;
    }

    //Check the diagonals
    if(board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != '-') {
      return true;
    }
    if(board[2][0] == board[1][1] && board[1][1] ==  board[0][2] && board[2][0] != '-') {
      return true;
    }

    //Otherwise nobody has not won yet
    return false;
  }

  private boolean isBoardFull(){
    for(int row = 0; row < DEFAULT_BOARD_SIZE; row++){
      for(int col = 0; col < DEFAULT_BOARD_SIZE; col++){
        if(board[row][col] == '-')
          return false;
      }
    }
    return true;
  }

  /*-----------------------------Core Login----------------------------------*/
  public void startGame(){

    initialiseBoard();
    displayBoard();

    for(Move move: moves){
        char pieceValue ='-';

        if(playerX)
          pieceValue = players.get(0).getPieceValue();
        else
          pieceValue = players.get(1).getPieceValue();

        int row = move.getRow()-1;
        int col = move.getCol()-1;


        if(isValidMove(row,col)){
          board[row][col] = pieceValue;
        }
        else{
          System.out.println("Invalid Move");
          continue;
        }

        displayBoard();

        if(hasPlayerWonTheGame()){
          if(playerX)
            System.out.println(players.get(0).getName()+" "+ "has won the game");
          else
            System.out.println(players.get(1).getName()+" "+ "has won the game");
          isGameCompleted = true;
        }

        if(isBoardFull()){
          System.out.println("Game Over");
          isGameCompleted = true;
        }else{
          playerX = !playerX;
        }

        if(isGameCompleted)
          break;
    }
  }



}
