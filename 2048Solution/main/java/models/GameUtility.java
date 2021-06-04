package main.java.models;

import java.util.Random;

public class GameUtility {
    void getRandomIndex(GameBoard board){
        board.resetGetRandomFrom();
        int index =  new Random().nextInt(board.getGetRandomFrom().size());
        int itemIndex = board.getGetRandomFrom().get(index);
        board.getGetRandomFrom().remove(Integer.valueOf(index));
        int columnValue = itemIndex%board.getSize();
        if(columnValue == 0)
            columnValue = board.getSize();
        board.setRowToBeFilled((int)Math.ceil((double)itemIndex/board.getSize())-1);
        board.setColumnToBeFilled(columnValue-1);
    }
}
