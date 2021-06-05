package main.java.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Driver {

  public static void main(String[] args) {
    int NO_OF_ROWS_GAME_BOARD = 3;
    int NO_OF_COLUMNS_GAME_BOARD = 3;
    int NO_OF_PLAYERS = 2;
    List<UserRowColumnInput> userRowColumnInputs = new ArrayList<>();
    List<Player> players = new ArrayList<>();
    Scanner sc = new Scanner((System.in));
    for(int i=1;i<=NO_OF_PLAYERS;i++) {
      Player player = new Player();
      player.setChosenCharacter(sc.next().charAt(0));
      player.setName(sc.next());
      players.add(player);
    }

    while(true) {
      String inputRowNum = sc.next();
      if(inputRowNum.equals("exit")) {
        break;
      }
      String inputColumnNum = sc.next();
      UserRowColumnInput userRowColumnInput = new UserRowColumnInput();
      userRowColumnInput.setInputRowNum(Integer.parseInt(inputRowNum));
      userRowColumnInput.setInputColumnNum(Integer.parseInt(inputColumnNum));
      userRowColumnInputs.add(userRowColumnInput);
    }
    TicTacToeService ticTacToeService = new TicTacToeService();
    ticTacToeService.setNoOfRowsGameBoard(NO_OF_ROWS_GAME_BOARD);
    ticTacToeService.setNoOfColumnsGameBoard(NO_OF_COLUMNS_GAME_BOARD);
    ticTacToeService.setGrid(NO_OF_ROWS_GAME_BOARD,NO_OF_COLUMNS_GAME_BOARD);
    ticTacToeService.setPlayers(players);
    ticTacToeService.setUserRowColumnInputs(userRowColumnInputs);
    ticTacToeService.startGame();

  }

}
