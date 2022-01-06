package Game2048;

import Game2048.models.Board;

import java.lang.*;
import java.util.Scanner;


public class GameController {

    public static void main(String[] args)  throws java.lang.Exception{

        boolean isGameUnderProgress = true;

        while (isGameUnderProgress) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the size of the board, base number & winning number in power of the base number respectively");
            int sizeOfBoard, winningNumber, baseNumber;

            sizeOfBoard = scanner.nextInt();
            baseNumber = scanner.nextInt();
            winningNumber = scanner.nextInt();

            Board board = new Board(sizeOfBoard, baseNumber, winningNumber);
            System.out.println("Enter 0 for left, 1 for right, 2 for top, 3 for bottom");

            boolean isCurrentGameUnderProgress = true;

            while (isCurrentGameUnderProgress){

                int currentMove = scanner.nextInt();
                if(currentMove !=0 && currentMove !=1 && currentMove!= 2 && currentMove!=3){
                    System.out.println("Invalid Move");
                    continue;
                }
                int currentStatus = 2;
                currentStatus = board.gameControl(currentMove);
                if(currentStatus == 0){
                    System.out.println("Game Over");
                    isCurrentGameUnderProgress = false;
                }
                else if(currentStatus == 1){
                    System.out.println("You won");
                    isCurrentGameUnderProgress = false;
                }
            }
            System.out.println("Enter 'exit' for exit or any other key to restart the game");
            String response = scanner.next();
            if(response.equals("exit")) {
                isGameUnderProgress = false;
            }
        }
        System.exit(0);
    }
}
