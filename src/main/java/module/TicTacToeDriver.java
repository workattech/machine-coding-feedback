package main.java.module;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TicTacToeDriver {
    public static  void main(String args[]){
        TicTacToeService ticTacToeService = new TicTacToeService();
        Scanner a = new Scanner(System.in);

        char firstPlayer = a.next().charAt(0);
        String firstPlayerName = a.next();
        char secondPlayer = a.next().charAt(0);
        String secondPlayerName = a.next();


        Player player1 = new Player();
        player1.setSymbol(firstPlayer);
        player1.setName(firstPlayerName);

        Player player2 = new Player();
        player1.setSymbol(firstPlayer);
        player1.setName(firstPlayerName);
        List<Player> players = new ArrayList<>();
        players.add(player1);
        players.add(player2);
        ticTacToeService.initializeBoard(3, 3);
        List<Pieces> pieces = new ArrayList<>();
        while(a.hasNext()){
            if(a.hasNextInt()){
                int row = a.nextInt();
                int col = a.nextInt();
                Pieces piece= new Pieces();
                piece.setRow(row);
                piece.setCol(col);
                pieces.add(piece);
            }else{
                break;
            }
        }
        ticTacToeService.setPlayerSequence(players);

        ticTacToeService.startGame(pieces);
    }
}
