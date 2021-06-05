package main.java.models;

import java.util.List;

public class TicTacToeService {
  private final GameBoard gameboard = new GameBoard();

  public void setNoOfColumnsGameBoard(int setNoOfColumnsGameBoard) {
    gameboard.setNoOfColumnsGameBoard(setNoOfColumnsGameBoard);
  }

  public void setNoOfRowsGameBoard(int setNoOfRowsGameBoard) {
    gameboard.setNoOfRowsGameBoard(setNoOfRowsGameBoard);
  }

  public void setPlayers(List<Player> players) {
    gameboard.setPlayers(players);
  }

  public void setUserRowColumnInputs(List<UserRowColumnInput> userRowColumnInputs) {
    gameboard.setUserRowColumnInputs(userRowColumnInputs);
  }

  public void setGrid(int noOfRowsGameBoard, int noOfColumnsGameBoard) {
    gameboard.setGrid(noOfRowsGameBoard,noOfColumnsGameBoard);
  }

  public void startGame() {

    String [][]grid = gameboard.getGrid();
    initialiseGameBoard(grid);
    displayGrid(grid);
    List<Player> playerQueue;
    playerQueue = gameboard.getPlayers();
    for(int k=0;k<gameboard.getUserRowColumnInputs().size();k++) {
      Player currentPlayer = playerQueue.get(0);
      playerQueue.remove(0);
      int inputRowNum = gameboard.getUserRowColumnInputs().get(k).getInputRowNum();
      int inputColumnNum = gameboard.getUserRowColumnInputs().get(k).getInputColumnNum();
      if(!isValidMove(grid,inputRowNum,inputColumnNum)) {
        System.out.println("Invalid Move");
        playerQueue.add(0,currentPlayer);
      }
      else {
        grid[inputRowNum-1][inputColumnNum-1] = currentPlayer.getChosenCharacter()+" ";
        displayGrid(grid);
        if(isGameComplete(grid)) {
          System.out.println("Game Over");
          break;
        }
        if(rowCheck(grid,inputRowNum,inputColumnNum) || columnCheck(grid,inputRowNum,inputColumnNum)
            || leftDiagonalCheck(grid,inputRowNum,inputColumnNum) || rightDiagonalCheck(grid,inputRowNum,inputColumnNum)) {
          System.out.println(currentPlayer.getName()+" won the game");
          break;
        }
        playerQueue.add(currentPlayer);
      }
    }
  }

  private void displayGrid(String[][] grid) {
    for (String[] strings : grid) {
      for (String string : strings) {
        System.out.print(string);
      }
      System.out.println();
    }
  }

  private boolean isValidMove(String [][]grid,int inputRowNum,int inputColumnNum) {
    return grid[inputRowNum - 1][inputColumnNum - 1].equals("- ") && (inputRowNum >= 1
        && inputRowNum <= grid.length)
        && (inputColumnNum >= 1 && inputColumnNum <= grid.length);
  }

  private boolean columnCheck(String [][]grid,int inputRowNum,int inputColumnNum) {
    for(int i=0;i<grid.length;i++) {
      if(!grid[inputRowNum - 1][i].equals(grid[inputRowNum - 1][inputColumnNum - 1])) {
        return false;
      }
    }
    return true;
  }

  private boolean rowCheck(String [][]grid,int inputRowNum,int inputColumnNum) {
    for (String[] strings : grid) {
      if (!strings[inputColumnNum - 1].equals(grid[inputRowNum - 1][inputColumnNum - 1])) {
        return false;
      }
    }
    return true;
  }

  private boolean leftDiagonalCheck(String [][]grid,int inputRowNum,int inputColumnNum) {
    int characterCounter=0;
    for(int i=0;i<grid.length;i++) {
      for(int j=0;j<grid.length;j++) {
        if(i==j && grid[i][j].equals(grid[inputRowNum - 1][inputColumnNum - 1])) {
          characterCounter++;
        }
      }
    }
    return characterCounter == grid.length;
  }

  private boolean rightDiagonalCheck(String [][]grid,int inputRowNum,int inputColumnNum) {
    int characterCounter=0;
    for(int i=grid.length-1;i>=0;i--) {
      for(int j=grid.length-1;j>=0;j--) {
        if(i==j && grid[i][j].equals(grid[inputRowNum - 1][inputColumnNum - 1])) {
          characterCounter++;
        }
      }
    }
    return characterCounter == grid.length;
  }

  private boolean isGameComplete(String [][]grid) {
    int xCounter = 0;
    int oCounter = 0;
    int noOfRowsGrid = grid.length;
    for (String[] strings : grid) {
      for (int j = 0; j < grid.length; j++) {
        if (strings[j].equals("X ")) {
          xCounter++;
        } else if (strings[j].equals("0 ") || strings[j].equals("O ")) {
          oCounter++;
        }
      }
    }

    return xCounter == Math.ceil((noOfRowsGrid * noOfRowsGrid) / 2.0) && oCounter == Math
        .floor((noOfRowsGrid * noOfRowsGrid) / 2.0);
  }

  private void initialiseGameBoard(String[][] grid) {
    for(int i=0;i<gameboard.getNoOfRowsGameBoard();i++) {
      for(int j=0;j<gameboard.getNoOfColumnsGameBoard();j++) {
        grid[i][j] = "- ";
      }
    }
  }

}
