import models.Board;
import models.Player;
import services.TicTacToeGameService;

import java.util.*;

public class Driver {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int boardSize;
        Board board;
        System.out.print("Enter Board Size: ");
        boardSize = sc.nextInt();
        board = new Board(boardSize);
        System.out.print("Enter Number of Players: ");
        int noOfPlayers;
        List<Player> playerList = new ArrayList<Player>();
        noOfPlayers = sc.nextInt();
        for(int playerNo = 0; playerNo < noOfPlayers; playerNo++) {
            char symbol;
            String name;
            System.out.println("Enter Player Symbol and Name");
            symbol = sc.next().charAt(0);
            name = sc.next();
            playerList.add(new Player(name, symbol));
        }
        TicTacToeGameService gameService = new TicTacToeGameService(playerList, board);
        gameService.startGame();
    }
}
