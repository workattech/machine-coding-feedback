import model.Board;
import model.PlayerColour;
import services.BoardService;
import services.PrinterService;

import java.util.Scanner;

public class Driver {

    private static final String EXIT_COMMAND = "exit";

    public static void main(String[] args) {

        Board board = new Board();
        PrinterService printerService = new PrinterService(board);
        BoardService boardService = new BoardService(board, printerService);

        boardService.initiliazeBlackPieces();
        boardService.initiliazeWhitePieces();

        printerService.printBoard();

        Scanner sc = new Scanner(System.in);


        String input = "";
        String startPos, endPos;
        PlayerColour players[] = {PlayerColour.WHITE, PlayerColour.BLACK};
        int turn = 0;
        PlayerColour playerColour;

        while (!input.equals(EXIT_COMMAND)) {
            playerColour = players[turn % 2];
            input = sc.nextLine();
            String[] command = input.split(" ");
            if (command[0].equals(EXIT_COMMAND)) break;
            startPos = command[0];
            endPos = command[1];
            if (boardService.move(startPos, endPos, playerColour)) {
                printerService.printBoard();
                turn++;
            } else {
                printerService.printInvalidMove();
            }


        }


    }


}
