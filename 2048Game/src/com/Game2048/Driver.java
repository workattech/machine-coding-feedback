package com.Game2048;

import java.util.Scanner;

public class Driver {

  public static void main(String[] args) {
    Game2048Service newGame = new Game2048Service();

    newGame.assignTwoOrFourRandomlyOnTheBoard();
    newGame.assignTwoOrFourRandomlyOnTheBoard();
    newGame.displayBoard();

    Scanner scan = new Scanner(System.in);

    boolean isGameCompleted = true;

    while(isGameCompleted){
      int direction = scan.nextInt();

      if(direction == 0){
        newGame.slideNonEmptySlideTilesLEFT();
        newGame.assignTwoOrFourRandomlyOnTheBoard();
        newGame.displayBoard();
      }
      else if(direction == 1){
        newGame.slideNonEmptySlideTilesRIGHT();
        newGame.assignTwoOrFourRandomlyOnTheBoard();
        newGame.displayBoard();

      }
      else if(direction == 2){
        newGame.slideNonEmptyTilesUP();
        newGame.assignTwoOrFourRandomlyOnTheBoard();
        newGame.displayBoard();

      }
      else if(direction == 3){
        newGame.slideNonEmptySlideTilesDOWN();
        newGame.assignTwoOrFourRandomlyOnTheBoard();
        newGame.displayBoard();

      }
      else{
        continue;
      }

      if(newGame.getTileHavingMaxValue() == 2048){
        System.out.println("Congratulations");
        isGameCompleted = false;
      }
      if(newGame.allTilesFilled()){
        System.out.println("Game Over");
        isGameCompleted = false;
      }
      if(newGame.GameOver()){
        System.out.println("Game Over");
        isGameCompleted = false;
      }
    }


  }

}
