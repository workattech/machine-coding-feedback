package main.java.models;

import java.util.List;

public class GameBoard {
  private int noOfRowsGameBoard;
  private int noOfColumnsGameBoard;
  private String[][] grid;
  private List<Player> players;
  private List<UserRowColumnInput> userRowColumnInputs;

  public List<UserRowColumnInput> getUserRowColumnInputs() {
    return userRowColumnInputs;
  }

  public void setUserRowColumnInputs(
      List<UserRowColumnInput> userRowColumnInputs) {
    this.userRowColumnInputs = userRowColumnInputs;
  }

  public int getNoOfRowsGameBoard() {
    return noOfRowsGameBoard;
  }

  public void setNoOfRowsGameBoard(int noOfRowsGameBoard) {
    this.noOfRowsGameBoard = noOfRowsGameBoard;
  }

  public int getNoOfColumnsGameBoard() {
    return noOfColumnsGameBoard;
  }

  public void setNoOfColumnsGameBoard(int noOfColumnsGameBoard) {
    this.noOfColumnsGameBoard = noOfColumnsGameBoard;
  }

  public List<Player> getPlayers() {
    return players;
  }

  public void setPlayers(List<Player> players) {
    this.players = players;
  }

  public String[][] getGrid() {
    return grid;
  }

  public void setGrid(int noOfRowsGameBoard, int noOfColumnsGameBoard) {
    grid = new String[noOfRowsGameBoard][noOfColumnsGameBoard];
  }
}
