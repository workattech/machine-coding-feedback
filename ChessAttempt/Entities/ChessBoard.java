package Entities;

import Entities.PeiceType.*;

public class ChessBoard {
    private Peice[][] board;
    public ChessBoard(){
        this.board = new Peice[8][8];
        initialiseBoard();
    }
    public void initialiseBoard(){
        board[0][0]=new Rook(false,"BR");
        board[0][1]=new Knight(false,"BN");
        board[0][2]=new Bishop(false,"BB");
        board[0][3]=new Queen(false,"BQ");
        board[0][4]=new King(false,"BK");
        board[0][5]=new Bishop(false,"BB");
        board[0][6]=new Knight(false,"BN");
        board[0][7]=new Rook(false,"BR");
        for(int j=0;j<8;j++){
            board[1][j]=new Pawn(false,"BP");
        }



        board[7][0]=new Rook(true,"WR");
        board[7][1]=new Knight(true,"WN");
        board[7][2]=new Bishop(true,"WB");
        board[7][3]=new Queen(true,"WQ");
        board[7][4]=new King(true,"WK");
        board[7][5]=new Bishop(true,"WB");
        board[7][6]=new Knight(true,"WN");
        board[7][7]=new Rook(true,"WR");
        for(int j=0;j<8;j++){
            board[6][j]=new Pawn(true,"WP");
        }
    }

    public Peice getPeice(int i,int j){
        return board[i][j];
    }

    public void setPeice(int i,int j,Peice p){
        board[i][j]=p;
    }


    public void showBoard(){
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                if(board[i][j]==null){
                    System.out.print("-- ");
                }else {
                    System.out.print(board[i][j].getName() + " ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}
