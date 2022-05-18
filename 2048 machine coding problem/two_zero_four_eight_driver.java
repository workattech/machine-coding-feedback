package TwoZeroFourEight;

import java.util.Scanner;

public class two_zero_four_eight_driver {
    public static void main(String[] args) {
        GameBoardService gameBoardService = new GameBoardService();
        gameBoardService.startGame();
        while(true)
        {
            if(gameBoardService.getGameWon()) {
                System.out.println("you won");
                break;
            }
            if(gameBoardService.getGameLost()) {
                System.out.println("you lost");
                break;
            }

            Scanner sc = new Scanner(System.in);
            String move = sc.nextLine();
            gameBoardService.playMove(move);
        }
    }
}
