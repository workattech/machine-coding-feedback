package com.practise;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Board board = new Board(4,4);
        board.initializeBoard();
        board.displayBoard();

        Scanner sc = new Scanner(System.in);

        // user input
        while(true){
            // make move
            int move = sc.nextInt();
            if(move==0){
                board.moveLeft();
            }else if(move==1){
                board.moveRight();
            }else if(move==2){
                board.moveUp();
            }else{
                board.moveDown();
            }

            if(board.gameStatus() == 2){
                board.displayBoard();
                System.out.println("Congratulations");
                break;
            }
            if(board.gameStatus() == 0){
                board.displayBoard();
                System.out.println("Game over");
                break;
            }

            board.fillRandomTile();
            board.displayBoard();
        }

    }
}
