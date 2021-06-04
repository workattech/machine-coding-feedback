package main.java.models;
import java.util.ArrayList;
import java.lang.Integer;
public class GameService {
    GameBoard board = new GameBoard();
    GameUtility gameUtility = new GameUtility();
    void initialize(int size){
        board.setSize(size);
        board.initializeBoard(size);
        fillValueInBoard();
        fillValueInBoard();
    }

    void fillValueInBoard(){
        gameUtility.getRandomIndex(board);
        board.setValueInBoard(board.getRowToBeFilled(),board.getColumnToBeFilled(), 2);
    }
    void printValues(){
        for(int i = 0; i < board.getSize(); i++){
            for(int j = 0; j < board.getSize(); j++){
                if(board.getValueInBoard(i,j) == 0){
                    System.out.print("- ");
                }
                else{
                    System.out.print(board.getValueInBoard(i,j) + " ");
                }
            }
            System.out.println();
        }
    }
    void startGame(int direction){
       makeDecision(direction);
       fillValueInBoard();
       printValues();
    }
    boolean hasWon(){
        for(int i = 0; i< board.getSize(); i++){
            for(int j=  0; j < board.getSize(); j++){
                if(board.getValueInBoard(i,j) == 2048){
                    return true;
                }
            }
        }
        return false;
    }
    boolean isGameOver(){
        for(int i = 0; i< board.getSize(); i++) {
            for (int j = 0; j < board.getSize(); j++) {
                if(board.getValueInBoard(i,j) == 0)
                    return false;
            }
        }
        return true;
    }
    void makeDecision(int direction){
        switch (direction) {
            case 0 -> moveAllColumnsLeft();
            case 1 -> moveAllColumnRight();
            case 2 -> moveAllRowsUp();
            case 3 -> moveAllRowsDown();
        }
    }
    private void moveAllRowsDown() {
        for (int eachColumn = 0; eachColumn < board.getSize(); eachColumn++) {
            ArrayList<Integer> continuousNonZeroElements = new ArrayList<>();
            for (int eachRowInaColumn = board.getSize()-1; eachRowInaColumn >= 0; eachRowInaColumn--) {
                if (board.getValueInBoard(eachRowInaColumn, eachColumn) != 0) {
                    continuousNonZeroElements.add(board.getValueInBoard(eachRowInaColumn, eachColumn));
                }
            }
            int index = board.getSize()-1;
            int iterator=1;
            if(continuousNonZeroElements.size() == 1){
                board.setValueInBoard(index,eachColumn, continuousNonZeroElements.get(0));
                index--;
            }
            while(iterator < continuousNonZeroElements.size()){
                if(continuousNonZeroElements.get(iterator)
                    .equals(continuousNonZeroElements.get(iterator - 1))){
                    board.setValueInBoard(index,eachColumn, continuousNonZeroElements.get(iterator)*2);
                    index--;
                    if(iterator+1 == continuousNonZeroElements.size()-1) {
                        board.setValueInBoard(index, eachColumn, continuousNonZeroElements.get(iterator + 1));
                        index--;
                    }
                    iterator+=2;
                }
                else{
                    board.setValueInBoard(index, eachColumn, continuousNonZeroElements.get(iterator-1));
                    index--;
                    if(iterator == continuousNonZeroElements.size()-1){
                        board.setValueInBoard(index,eachColumn, continuousNonZeroElements.get(iterator));
                        index--;
                    }
                    iterator++;
                }
            }
            for (int j = 0; j <= index; j++) {
                board.setValueInBoard(j, eachColumn, 0);
            }
        }
    }

    private void moveAllRowsUp() {
        for (int eachColumn = 0; eachColumn < board.getSize(); eachColumn++) {
            ArrayList<Integer> continuousNonZeroElements = new ArrayList<>();
            for (int eachRowInaColumn = 0; eachRowInaColumn < board.getSize(); eachRowInaColumn++) {
                if (board.getValueInBoard(eachRowInaColumn, eachColumn) != 0) {
                    continuousNonZeroElements.add(board.getValueInBoard(eachRowInaColumn, eachColumn));
                }
            }

            int index = 0;
            int iterator=1;
            if(continuousNonZeroElements.size() == 1){
                board.setValueInBoard(index,eachColumn, continuousNonZeroElements.get(0));
                index++;
            }
            while(iterator < continuousNonZeroElements.size()){
                if(continuousNonZeroElements.get(iterator)
                    .equals(continuousNonZeroElements.get(iterator - 1))){
                    board.setValueInBoard(index,eachColumn, continuousNonZeroElements.get(iterator)*2);
                    index++;
                    if(iterator+1 == continuousNonZeroElements.size()-1) {
                        board.setValueInBoard(index, eachColumn, continuousNonZeroElements.get(iterator + 1));
                        index++;
                    }
                    iterator+=2;
                }
                else{
                    board.setValueInBoard(index, eachColumn, continuousNonZeroElements.get(iterator-1));
                    index++;
                    if(iterator == continuousNonZeroElements.size()-1){
                        board.setValueInBoard(index,eachColumn, continuousNonZeroElements.get(iterator));
                        index++;
                    }
                    iterator++;
                }
            }
            //set remaining values as zero
            for (int j = index; j < board.getSize(); j++) {
                board.setValueInBoard(j, eachColumn,0);
            }
        }
    }

    private void moveAllColumnsLeft() {
        for (int eachRow = 0; eachRow < board.getSize(); eachRow++) {
            ArrayList<Integer> continuousNonZeroElements = new ArrayList<>();
            for (int eachColumnInaRow = 0; eachColumnInaRow < board.getSize(); eachColumnInaRow++) {
                if (board.getValueInBoard(eachRow, eachColumnInaRow) != 0) {
                    continuousNonZeroElements.add(board.getValueInBoard(eachRow, eachColumnInaRow));
                }
            }
            int index = 0;
            int iterator=1;
            if(continuousNonZeroElements.size() == 1){
                board.setValueInBoard(eachRow, index, continuousNonZeroElements.get(0));
                index++;
            }
            while(iterator < continuousNonZeroElements.size()){
                if(continuousNonZeroElements.get(iterator)
                    .equals(continuousNonZeroElements.get(iterator - 1))){
                    board.setValueInBoard(eachRow, index, continuousNonZeroElements.get(iterator)*2);
                    index++;
                    if(iterator+1 == continuousNonZeroElements.size()-1) {
                        board.setValueInBoard(eachRow, index, continuousNonZeroElements.get(iterator + 1));
                        index++;
                    }
                    iterator+=2;
                }
                else{
                    board.setValueInBoard(eachRow, index, continuousNonZeroElements.get(iterator-1));
                    index++;
                    if(iterator == continuousNonZeroElements.size()-1){
                        board.setValueInBoard(eachRow, index, continuousNonZeroElements.get(iterator));
                        index++;
                    }
                    iterator++;
                }
            }
            //set remaining values as zero
            for (int j = index; j <= board.getSize()-1; j++) {
                board.setValueInBoard(eachRow, j, 0);
            }
        }
    }

    private void moveAllColumnRight() {
        for (int eachRow = 0; eachRow < board.getSize(); eachRow++) {
            ArrayList<Integer> continuousNonZeroElements = new ArrayList<>();
            for (int eachColumnInaRow = board.getSize()-1; eachColumnInaRow >= 0;  eachColumnInaRow--) {
                if (board.getValueInBoard(eachRow, eachColumnInaRow) != 0) {
                    continuousNonZeroElements.add(board.getValueInBoard(eachRow, eachColumnInaRow));
                }
            }
            int index = board.getSize()-1;
            int iterator=1;
            if(continuousNonZeroElements.size() == 1){
                board.setValueInBoard(eachRow, index, continuousNonZeroElements.get(0));
                index--;
            }
            while(iterator < continuousNonZeroElements.size()){
                if(continuousNonZeroElements.get(iterator)
                    .equals(continuousNonZeroElements.get(iterator - 1))){
                    board.setValueInBoard(eachRow, index, continuousNonZeroElements.get(iterator)*2);
                    index--;
                    if(iterator+1 == continuousNonZeroElements.size()-1) {
                        board.setValueInBoard(eachRow, index, continuousNonZeroElements.get(iterator + 1));
                        index--;
                    }
                    iterator+=2;
                }
                else{
                    board.setValueInBoard(eachRow, index, continuousNonZeroElements.get(iterator-1));
                    index--;
                    if(iterator == continuousNonZeroElements.size()-1){
                        board.setValueInBoard(eachRow, index, continuousNonZeroElements.get(iterator));
                        index--;
                    }
                    iterator++;
                }
            }
            //set remaining values as zero
            for (int j = 0; j <= index; j++) {
                board.setValueInBoard(eachRow, j, 0);
            }
        }
    }
}