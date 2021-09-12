package game2048;

import game2048.model.Board;

import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter height of board");
        int h=sc.nextInt();
        System.out.println("Enter width of board");
        int w=sc.nextInt();
        System.out.println("Enter winning value");
        int winningValue=sc.nextInt();
        Board b=new Board(h,w,winningValue);
        boolean gameOver=false;
        boolean gameLost=false;
        while(!gameLost && !gameOver){
            int move=sc.nextInt();
            if(move==0){
                b.removeSpaceInLeftDirection(b.getBoardSideHeight(),b.getBoardSideWidth());
                b.mergeInLeftDirection(b.getBoardSideHeight(),b.getBoardSideWidth());
                b.removeSpaceInLeftDirection(b.getBoardSideHeight(),b.getBoardSideWidth());
                b.randomTileInserter();

            }else if(move==1){
                b.removeSpaceInRightDirection(b.getBoardSideHeight(),b.getBoardSideWidth());
                b.mergeInRightDirection(b.getBoardSideHeight(),b.getBoardSideWidth());
                b.removeSpaceInRightDirection(b.getBoardSideHeight(),b.getBoardSideWidth());
                b.randomTileInserter();
            }else if(move==2){
                b.removeSpaceInTopDirection(b.getBoardSideHeight(),b.getBoardSideWidth());
                b.mergeInTopDirection(b.getBoardSideHeight(),b.getBoardSideWidth());
                b.removeSpaceInTopDirection(b.getBoardSideHeight(),b.getBoardSideWidth());
                b.randomTileInserter();
            }else if(move==3){
                b.removeSpaceInBottomDirection(b.getBoardSideHeight(),b.getBoardSideWidth());
                b.mergeInBottomDirection(b.getBoardSideHeight(),b.getBoardSideWidth());
                b.removeSpaceInBottomDirection(b.getBoardSideHeight(),b.getBoardSideWidth());
                b.randomTileInserter();
            }else{
                System.out.println("Invalid move");
            }
            gameOver=b.isGameWon(b.getBoardSideHeight(),b.getBoardSideWidth());
            gameLost=b.isGameLost(b.getBoardSideHeight(),b.getBoardSideWidth());
            b.printBoard(b.getBoardSideHeight(),b.getBoardSideWidth());
        }
        if(gameLost){
            System.out.println("Game over");
        }
        if(gameOver){
            System.out.println("Congratulations");
        }
    }
}
