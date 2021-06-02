package com.tictactoe;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.tictactoe.models.Board;
import com.tictactoe.models.Player;
import com.tictactoe.models.Move;
import com.tictactoe.GameEngine;


public class Driver {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    Player player1 = new Player(scanner.next().charAt(0), scanner.next());
    Player player2 = new Player(scanner.next().charAt(0), scanner.next());

    List<Player> players = new ArrayList<>();
    players.add(player1);
    players.add(player2);

    List<Move> moves = new ArrayList<>();

    while(scanner.hasNext()){
      if(scanner.hasNextInt()){
        moves.add(new Move(scanner.nextInt(), scanner.nextInt()));
      }else{
        break;
      }
    }

    /*for(int i =0;i < moves.size(); i++){
      System.out.print(moves.get(i).getRow());
      System.out.print(moves.get(i).getCol() );
      System.out.println();
    }*/

    GameEngine gameEngine = new GameEngine();
    gameEngine.setMoves(moves);
    gameEngine.setPlayers(players);

    gameEngine.startGame();










  }

}
