package com.Game2048;

import com.Game2048.models.Board;

public class Game2048Service {

  private Board gameBoard;
  private int border = 0;
  public int score = 0;


  public Game2048Service(){
    gameBoard = new Board();
  }

  public void assignTwoOrFourRandomlyOnTheBoard(){
    boolean emptyTile = true;

    while(emptyTile){
      int row = (int)(Math.random() * 4);
      int col = (int)(Math.random() * 4);

      //System.out.println(row+"  "+col);

      double probabilityOfPuttingTwoOrFour = Math.random();

      if(gameBoard.getBoardValue(row,col).getTileValue().equals("-")){

        if(probabilityOfPuttingTwoOrFour < 0.2){
          gameBoard.setBoardValue(row,col,"4");
          //System.out.println(gameBoard.getBoardValue(row,col).getTileValue());
        }else{
          gameBoard.setBoardValue(row,col,"2");
          //System.out.println(gameBoard.getBoardValue(row,col).getTileValue());
        }
        emptyTile = false;
      }
    }

  }
  public void displayBoard(){
    for(int i = 0; i < gameBoard.getRow(); i++){
      for(int j = 0; j < gameBoard.getCol(); j++){
        System.out.print(gameBoard.getBoardValue(i,j).getTileValue()+" ");
      }
      System.out.println();
    }
  }

  public int getTileHavingMaxValue(){
    Integer maxValue = (gameBoard.getBoardValue(0,0).getTileValue().equals("-")) ? Integer.parseInt("0") : Integer.parseInt(gameBoard.getBoardValue(0,0).getTileValue());
    //Integer maxValue = Integer.parseInt(gameBoard.getBoardValue(0,0).getTileValue());

    for(int row = 0; row < gameBoard.getRow(); row++){
      for (int col = 0; col < gameBoard.getCol(); col++){
        Integer currentTileValue;
        if(gameBoard.getBoardValue(row,col).getTileValue().equals("-")){
          currentTileValue = Integer.parseInt("0");
        }else{
          currentTileValue = Integer.parseInt(gameBoard.getBoardValue(row,col).getTileValue());
        }

        if(maxValue < currentTileValue){
          maxValue = currentTileValue;
        }
      }
    }
    return maxValue;
  }

  public void slideNonEmptyTilesUP(){
    for(int col = 0; col < gameBoard.getCol(); col++){
      border = 0;
      for(int row = 0; row < gameBoard.getRow(); row++){

        //String tileValue = gameBoard.getBoardValue(row,col).getTileValue();

        if(!gameBoard.getBoardValue(row,col).getTileValue().equals("-")){

          if(border <= row){
            moveTilesInVerticalDirection(row,col,"up");
          }
        }

      }
    }
  }

  public void slideNonEmptySlideTilesDOWN(){
    for(int col = 0; col < gameBoard.getCol(); col++){
      border = gameBoard.getCol()-1;
      for(int row = gameBoard.getRow()-1; row >= 0; row--){
        //int tileValue = Integer.parseInt(gameBoard.getBoardValue(row,col).getTileValue());

        if(!gameBoard.getBoardValue(row,col).getTileValue().equals("-")){
          if(border >= row){
            moveTilesInVerticalDirection(row,col,"down");
          }
        }
      }
    }
  }

  private void moveTilesInVerticalDirection(int row, int col, String direction){

    String initialValue = gameBoard.getBoardValue(border,col).getTileValue();
    String compareValue = gameBoard.getBoardValue(row,col).getTileValue();

    if(initialValue.equals("-") || initialValue.equals(compareValue)){
      if( border < row || direction.equals("down") && row < border){

        Integer addScore;

        if(initialValue.equals("-")){
          String val = "0";
          addScore = Integer.parseInt(val) + Integer.parseInt(gameBoard.getBoardValue(row,col).getTileValue());
        }
        else{
          addScore = Integer.parseInt(gameBoard.getBoardValue(border,col).getTileValue()) + Integer.parseInt(gameBoard.getBoardValue(row,col).getTileValue());
        }
        if(!initialValue.equals("-")){
          score = score + addScore;
        }
        gameBoard.setBoardValue(border,col,addScore.toString());
        gameBoard.setBoardValue(row,col,"-");
      }
    }
    else{
      if(direction.equals("up")){
        border++;
      }else{
        border--;
      }
      moveTilesInVerticalDirection(row,col,direction);
    }
  }

  public void slideNonEmptySlideTilesLEFT(){
    for(int row = 0; row < gameBoard.getRow(); row++){
      border = 0;
      for(int col = 0; col < gameBoard.getCol(); col++){
        if(!gameBoard.getBoardValue(row,col).getTileValue().equals("-")){
          if(border <= col){
            moveTilesInHorizontalDirection(row,col,"left");
          }
        }
      }
    }
  }

  public void slideNonEmptySlideTilesRIGHT(){
    for(int row = 0; row < gameBoard.getRow(); row++){
      border = gameBoard.getRow()-1;
      for(int col = 0; col < gameBoard.getCol(); col++){
        if(!gameBoard.getBoardValue(row,col).getTileValue().equals("-")){
          if(border >= col){
            moveTilesInHorizontalDirection(row,col,"right");
          }
        }
      }
    }

  }

  private void moveTilesInHorizontalDirection(int row, int col, String direction){
    String initialValue = gameBoard.getBoardValue(row,border).getTileValue();
    String compareValue = gameBoard.getBoardValue(row,col).getTileValue();

    if(initialValue.equals("-") || initialValue.equals(compareValue)){
      if(border < col || direction.equals("right") && border > col){
        Integer addScore;
        if(initialValue.equals("-")){
          String val = "0";
          addScore = Integer.parseInt(val) + Integer.parseInt(gameBoard.getBoardValue(row,col).getTileValue());
        }
        else{
          addScore = Integer.parseInt(gameBoard.getBoardValue(row,border).getTileValue()) + Integer.parseInt(gameBoard.getBoardValue(row,col).getTileValue());
        }
        if(!initialValue.equals("-")){
          score = score + addScore;
        }
        gameBoard.setBoardValue(row,border,addScore.toString());
        gameBoard.setBoardValue(row,col,"-");

      }
    }
    else{
      if(direction.equals("right")){
        border--;
      }else{
        border++;
      }
      moveTilesInHorizontalDirection(row,col,direction);
    }

  }

  public boolean allTilesFilled(){
    int noOFTiles = 0;
    for(int row = 0; row < gameBoard.getRow(); row++){
      for(int col = 0; col < gameBoard.getCol(); col++){
        String tileValue = gameBoard.getBoardValue(row,col).getTileValue().equals("-") ? "0" : gameBoard.getBoardValue(row,col).getTileValue();
        if(Integer.parseInt(tileValue) > 0){
          noOFTiles++;
        }
      }
    }
    if(noOFTiles == gameBoard.getCol()* gameBoard.getRow()){
      return true;
    }
    else{
      return false;
    }
  }



  public boolean GameOver(){
    int noOfTilesFilledAlready = 0;
    for(int i = 0; i < gameBoard.getRow();i++){
      for(int j = 0; j < gameBoard.getCol();j++){
        if(isAdjacentNodesAreDifferent(i,j)){
          noOfTilesFilledAlready++;
        }
      }
    }
    if(noOfTilesFilledAlready == gameBoard.getCol() * gameBoard.getRow()){
      return true;
    }else{
      return false;
    }
  }

  private boolean isAdjacentNodesAreDifferent(int row, int col){
    //Validating the corner nodes
    if(row == 0 && col == 0){
      if(!gameBoard.getBoardValue(row,col).getTileValue().equals(gameBoard.getBoardValue(row+1,col).getTileValue())
          && !gameBoard.getBoardValue(row,col).getTileValue().equals(gameBoard.getBoardValue(row,col+1).getTileValue())){
        return true;
      }
    } else if(row == gameBoard.getRow()-1 && col == 0){
      if(!gameBoard.getBoardValue(row,col).getTileValue().equals(gameBoard.getBoardValue(row-1,col).getTileValue())
      && !gameBoard.getBoardValue(row,col).getTileValue().equals(gameBoard.getBoardValue(row,col+1).getTileValue())){
        return true;
      }
    } else if(row == 0 && col == gameBoard.getCol()-1 ){
      if(gameBoard.getBoardValue(row, col).getTileValue().equals(gameBoard.getBoardValue(row+1,col).getTileValue())
      && gameBoard.getBoardValue(row,col).getTileValue().equals(gameBoard.getBoardValue(row,col-1).getTileValue())){
        return true;
      }
    } else if(row == gameBoard.getRow()-1 && col ==gameBoard.getCol()-1){
      if(gameBoard.getBoardValue(row,col).getTileValue().equals(gameBoard.getBoardValue(row,col-1).getTileValue())
      && gameBoard.getBoardValue(row,col).getTileValue().equals(gameBoard.getBoardValue(row-1,col).getTileValue())){
        return true;
      }
    } else if(row == 0 && (col == 1 || col ==2)){
      if(gameBoard.getBoardValue(row,col).getTileValue().equals(gameBoard.getBoardValue(row+1,col).getTileValue())
      && gameBoard.getBoardValue(row,col).getTileValue().equals(gameBoard.getBoardValue(row,col-1).getTileValue())
      && gameBoard.getBoardValue(row,col).getTileValue().equals(gameBoard.getBoardValue(row,col+1).getTileValue())){
        return true;
      }
    } else if(row == gameBoard.getRow()-1 && (col == 1 || col ==2)){
      if(gameBoard.getBoardValue(row,col).getTileValue().equals(gameBoard.getBoardValue(row-1,col).getTileValue())
          && gameBoard.getBoardValue(row,col).getTileValue().equals(gameBoard.getBoardValue(row,col-1).getTileValue())
          && gameBoard.getBoardValue(row,col).getTileValue().equals(gameBoard.getBoardValue(row,col+1).getTileValue())){
        return true;
      }
    } else if((row == 1 || row == 2) && col == 0){
      if(gameBoard.getBoardValue(row,col).getTileValue().equals(gameBoard.getBoardValue(row-1,col).getTileValue())
      && gameBoard.getBoardValue(row,col).getTileValue().equals(gameBoard.getBoardValue(row+1,col).getTileValue())
      && gameBoard.getBoardValue(row,col).getTileValue().equals(gameBoard.getBoardValue(row,col+1).getTileValue())){
        return true;
      }
    } else if((row == 1 || row == 2) && col == gameBoard.getCol()-1){
      if(gameBoard.getBoardValue(row,col).getTileValue().equals(gameBoard.getBoardValue(row-1,col).getTileValue())
          && gameBoard.getBoardValue(row,col).getTileValue().equals(gameBoard.getBoardValue(row+1,col).getTileValue())
          && gameBoard.getBoardValue(row,col).getTileValue().equals(gameBoard.getBoardValue(row,col-1).getTileValue())){
        return true;
      }
    } else {
      if(gameBoard.getBoardValue(row,col).getTileValue().equals(gameBoard.getBoardValue(row+1,col).getTileValue())
      && gameBoard.getBoardValue(row,col).getTileValue().equals(gameBoard.getBoardValue(row-1,col).getTileValue())
      && gameBoard.getBoardValue(row,col).getTileValue().equals(gameBoard.getBoardValue(row,col+1).getTileValue())
      && gameBoard.getBoardValue(row,col).getTileValue().equals(gameBoard.getBoardValue(row,col-1).getTileValue())){
        return true;
      }
    }
    return false;

  }



}
