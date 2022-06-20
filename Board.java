package com.practise;

import java.util.ArrayList;
import java.util.Arrays;

public class Board {

   private int[][] board;
   private ArrayList<int[]> emptyTiles;

   Board(int h, int w){
       // initialise board with 0s
       emptyTiles = new ArrayList<>();
       board = new int[h][w];
       for(int i = 0; i < board.length; i++) {
           for (int j = 0; j < board[0].length; j++) {
               board[i][j] = 0;
               emptyTiles.add(new int[]{i, j});
           }
       }
   }

   public void initializeBoard(){
       int rndIndex1 = (int)(Math.random() * emptyTiles.size());
       int rndIndex2 = (int)(Math.random() * emptyTiles.size());
       // to ensure two different tiles are filled when initialized
       while(rndIndex2 == rndIndex1){
           rndIndex2 = (int)(Math.random() * emptyTiles.size());
       }
       int[] pos1 = emptyTiles.get(rndIndex1);
       int[] pos2 = emptyTiles.get(rndIndex2);
       board[pos1[0]][pos1[1]] = 2;
       board[pos2[0]][pos2[1]] = 2;

   }

   public void displayBoard(){
       for(int[] row : board) {
           for (int i : row) {
               System.out.print(i);
               System.out.print("\t");
           }
           System.out.println();
       }
   }

   // return 0 if game all tiles are filled
   // return 1 if game is in progress
   // return 2 if won
   public int gameStatus(){
       emptyTiles = new ArrayList<>();
       for(int i = 0; i < board.length; i++){
           for(int j = 0; j <  board[0].length; j++){
               if(board[i][j] == 2048){
                   return 2;
               }else if(board[i][j] == 0){
                   emptyTiles.add(new int[]{i, j});
               }
           }
       }
       return emptyTiles.size()==0? 0: 1;
   }

   public void fillRandomTile(){
       // choose random position to fill
       int rndIndex = (int)(Math.random() * emptyTiles.size());
       int[] pos = emptyTiles.get(rndIndex);

       // choose number to fill
       if(Math.random() > 0.5) {
           board[pos[0]][pos[1]] = 2;
       }else {
           board[pos[0]][pos[1]] = 4;
       }
   }

   public void moveRight(){
       for(int i = 0; i < board.length; i++) {
           board[i] = slideToRight(board[i]);
       }
   }

   public int[] slideToRight(int[] row){
       int[] nRow = new int[board[0].length];
       int i = board[0].length-1;
       int j =  board[0].length-1;
       while( i>=0 ){
           if(row[i]==0){
               i--;
               continue;
           }else if (row[i] !=0 && nRow[j] == 0){
               nRow[j] = row[i];
               i--;
           }else if (row[i] == nRow[j]) {
               nRow[j] += row[i];
               i--;
               j--;
           }else {
               j--;
           }
       }
       return nRow;
   }

   public void moveLeft(){
       for(int i = 0; i < board.length; i++) {
           board[i] = slideToLeft(board[i]);
       }
   }

   public int[] slideToLeft(int[] row){
       int[] nRow = new int[board[0].length];
       int i = 0;
       int j = 0;
       while( i < board[0].length ){
           if(row[i]==0){
               i++;
               continue;
           }else if (row[i] !=0 && nRow[j] == 0){
               nRow[j] = row[i];
               i++;
           }else if (row[i] == nRow[j]) {
               nRow[j] += row[i];
               i++;
               j++;
           }else {
               j++;
           }
       }
       return nRow;
   }

   public void moveUp(){
       int[] col = new int[board.length];
       for(int j = 0; j < board[0].length; j++){
           for(int i = 0; i < board.length; i++){
               col[i] = board[i][j];
           }
           col = slideUp(col);
           for(int i = 0; i < board.length; i++){
               board[i][j] = col[i];
           }
       }
   }

   public int[] slideUp(int[] col){
       int[] nCol = new int[col.length];
       int i = 0;
       int j = 0;
       while( i < board.length ){
           if(col[i]==0){
               i++;
               continue;
           }else if (col[i] !=0 && nCol[j] == 0){
               nCol[j] = col[i];
               i++;
           }else if (col[i] == nCol[j]) {
               nCol[j] += col[i];
               i++;
               j++;
           }else {
               j++;
           }
       }
       return nCol;
   }

   public void moveDown(){
        int[] col = new int[board.length];
        for(int j = 0; j < board[0].length; j++){
            for(int i = 0; i < board.length; i++){
                col[i] = board[i][j];
            }
            col = slideDown(col);
            for(int i = 0; i < board.length; i++){
                board[i][j] = col[i];
            }
        }
   }

   public int[] slideDown(int[] col){
        int[] nCol = new int[col.length];
        int i = board.length-1;
        int j = board.length-1;
        while( i >= 0 ){
            if(col[i]==0){
                i--;
                continue;
            }else if (col[i] !=0 && nCol[j] == 0){
                nCol[j] = col[i];
                i--;
            }else if (col[i] == nCol[j]) {
                nCol[j] += col[i];
                i--;
                j--;
            }else {
                j--;
            }
        }
        return nCol;
   }

}
