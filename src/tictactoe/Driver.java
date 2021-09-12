package tictactoe;

import tictactoe.model.Player;
import tictactoe.model.Grid;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
//        int MinNumberOfPlayers=2;
        int numberOfPlayers;
//        int MinRows=3;
//        int Rows;
//        int MinCols=3;
//        int Cols;

        Scanner sc=new Scanner(System.in);
        List<Player> playerList;
        playerList = new ArrayList<Player>();
//        numberOfPlayers=2;
        playerList.add(new Player(sc.next(), sc.next()));//Adding Piece, Name to player
        playerList.add(new Player(sc.next(), sc.next()));//Adding Piece, Name to player
        Grid g = new Grid(3,
                3);
        int totalPossibleMoves;
        totalPossibleMoves = 9;
        while(true){
            if (g.getTotalMoves()==totalPossibleMoves){
                System.out.println("Game Over");
                System.exit(0);
            }
            else{
                for(Player p : playerList){
                    try {
                        do {
                            if (g.getTotalMoves() == totalPossibleMoves) {
                                System.out.println("Game Over");
                                System.exit(0);
                            }
                        }
                        while (!g.setGrid(sc.nextInt() - 1, sc.nextInt() - 1, p.getPiece()));
                    }
                    catch(InputMismatchException e){
                        System.exit(0);
                    }
                    if (!g.isPieceWinner(p.getPiece())) {
                        continue;
                    }
                    System.out.print(p.getName()+" won the game");
                    System.exit(0);
                }
            }

        }
    }

}

