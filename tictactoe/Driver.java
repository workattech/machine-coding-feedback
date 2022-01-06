package tictactoe;

import tictactoe.models.Board;
import tictactoe.models.Player;

import java.util.*;
import java.lang.*;
import java.io.*;
public class Driver {

    public static void main(String[] args)  throws java.lang.Exception{

        int sizeOfBoard = 3, numberOfPlayers = 2;
        Scanner scanner = new Scanner(System.in);
        Player playersList[] = new Player[numberOfPlayers];
        System.out.println("Welcome to the tic-tac-toe World");
        System.out.println("Enter your piece and name");
        for(int i=0; i<numberOfPlayers; i++){
            Character piece = scanner.next().charAt(0);
            String name = scanner.next();
            playersList[i] = new Player(name, piece);
        }
        Board board = new Board(sizeOfBoard);
        board.initializeTheBoard();
        board.printBoard();
        scanner.nextLine();

        boolean isGameInProgress = true;
        int currentPlayer =0, numberOfMoves =0, totalNumberOfMoves = sizeOfBoard*sizeOfBoard;

        while (isGameInProgress){
            if(numberOfMoves == totalNumberOfMoves){
                System.out.println("Game Over");
                isGameInProgress = false;
                continue;
            }
            String currentInput = scanner.nextLine();
            if(currentInput.equals("exit" )){
                isGameInProgress = false;
                continue;
            }
            String[] splitCurrentInput = currentInput.split(" ");
            int rowNumber =  Integer.parseInt(splitCurrentInput[0]) -1;
            int colNumber =  Integer.parseInt(splitCurrentInput[1]) -1;

            if(board.isPieceAtValidCell(rowNumber,colNumber)){
                board.setPieceAtBoard(rowNumber, colNumber, playersList[currentPlayer].getPiece());
                board.printBoard();
                if(board.hasPlayerWonTheGame(rowNumber, colNumber)){
                    System.out.println(playersList[currentPlayer].getName() + " won the game");
                    isGameInProgress = false;
                    continue;
                }
                currentPlayer++;
                if(currentPlayer == numberOfPlayers){
                    currentPlayer = 0;
                }
                numberOfMoves++;
            }
            else{
                System.out.println("Invalid Move");
            }
        }
        System.exit(0);
    }
}