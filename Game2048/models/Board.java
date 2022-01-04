package Game2048.models;

import java.util.*;
import java.lang.*;
import java.io.*;

public class Board {

    private int sizeOfBoard;
    private int winningNumber;
    private int baseNumber;
    private int board[][];
    private int totalOccupiedTiles;

    public Board(int sizeOfBoard, int baseNumber, int winningNumber){

        this.sizeOfBoard = sizeOfBoard;
        this.winningNumber = winningNumber;
        this.baseNumber = baseNumber;
        this.board = new int [sizeOfBoard][sizeOfBoard];
        this.totalOccupiedTiles = 0;
        initializeBoardWithDefaultValue();

    }

    public void initializeBoardWithDefaultValue(){

        for (int i=0; i < sizeOfBoard ; i++ ){
            for (int j=0; j < sizeOfBoard ; j++ ) {
                board[i][j] = 0;
            }
        }
        addRandomTileToTheBoard();
        printBoard();

    }

    public void printBoard(){

        for (int i=0; i < sizeOfBoard ; i++ ){
            for (int j=0; j < sizeOfBoard ; j++ ) {
                if (board[i][j] == 0){
                    System.out.print('-');
                }
                else{
                    System.out.print(board[i][j]);
                }
                System.out.print(' ');
            }
            System.out.println();
        }

    }

    //used to get random number in range[1,val]
    public int randomNumberGenerator(int number){
        return (int)(Math.random()*(number)+1);
    }

    public void addRandomTileToTheBoard() {

        int numberToPlace = baseNumber * randomNumberGenerator(2); // Either base number or 2*base number
        boolean hasNumberAdded = false;

        while (hasNumberAdded == false) {
            int rowNumber = randomNumberGenerator(sizeOfBoard);
            int columnNumber = randomNumberGenerator(sizeOfBoard);
            if (board[rowNumber - 1][columnNumber - 1] == 0) {
                board[rowNumber - 1][columnNumber - 1] = numberToPlace;
                hasNumberAdded = true;
            }
        }
        increaseOccupiedTilesCount();
    }

    public void increaseOccupiedTilesCount() {
        this.totalOccupiedTiles = this.totalOccupiedTiles + 1;
    }

    public void decreaseOccupiedTilesCount() {
        this.totalOccupiedTiles = this.totalOccupiedTiles - 1;
    }

    public int gameControl(int currentMove){

        if (currentMove == 0) {
            return leftSlide();
        }

        else if (currentMove == 1) {
            return rightSlide();
        }

        else if (currentMove == 2) {
            return topSlide();
        }
        else if (currentMove == 3) {
            return bottomSlide();
        }
        return 2;
    }

    public int leftSlide(){
        removeSpacesInLeftDirection();
        boolean status = mergeTilesInLeftDirection();
        if(status == true){
            printBoard();
            return 1;
        }
        return afterMergeProcess();
    }

    public void removeSpacesInLeftDirection(){

        for (int i=0; i<sizeOfBoard ; i++){
            int currentIndexOfEmptyTile = 0;
            for (int j =0 ;j< sizeOfBoard; j++){
                if (board[i][j] != 0 ){
                    if(board[i][currentIndexOfEmptyTile] == 0){
                        board[i][currentIndexOfEmptyTile] = board[i][j];
                        board[i][j] = 0;
                        currentIndexOfEmptyTile++;
                    }
                    else{
                        currentIndexOfEmptyTile++;
                    }
                }
            }
        }

    }

    public boolean mergeTilesInLeftDirection(){

        for (int i=0 ; i < sizeOfBoard; i++){
            for (int j=0; j < sizeOfBoard -1; j++){
                if (board[i][j] == board[i][j+1] && board[i][j]!=0){
                    board[i][j]  = 2*board[i][j];
                    board[i][j+1] = 0;
                    decreaseOccupiedTilesCount();
                }
            }
        }
        removeSpacesInLeftDirection();
        return hasPlayerWonTheGame();
    }


    public int rightSlide(){
        removeSpacesInRightDirection();
        boolean status = mergeTilesInRightDirection();
        if(status == true){
            printBoard();
            return 1;
        }
        return afterMergeProcess();
    }

    public void removeSpacesInRightDirection(){

        for (int i=0; i<sizeOfBoard ; i++){
            int currentIndexOfEmptyTile = sizeOfBoard-1;
            for (int j = sizeOfBoard-1 ;j >= 0; j--){
                if (board[i][j] != 0 ){
                    if(board[i][currentIndexOfEmptyTile] == 0){
                        board[i][currentIndexOfEmptyTile] = board[i][j];
                        board[i][j] = 0;
                        currentIndexOfEmptyTile--;
                    }
                    else{
                        currentIndexOfEmptyTile--;
                    }
                }
            }
        }

    }

    public boolean mergeTilesInRightDirection(){

        for (int i=0 ; i < sizeOfBoard; i++){
            for (int j= sizeOfBoard -1; j > 0; j--){
                if (board[i][j] == board[i][j-1]  && board[i][j]!=0){
                    board[i][j]  = 2*board[i][j];
                    board[i][j-1] = 0;
                    decreaseOccupiedTilesCount();
                }
            }
        }
        removeSpacesInRightDirection();
        return hasPlayerWonTheGame();
    }

    public int topSlide(){
        removeSpacesInTopDirection();
        boolean status = mergeTilesInTopDirection();
        if(status == true){
            printBoard();
            return 1;
        }
        return afterMergeProcess();
    }

    public void removeSpacesInTopDirection(){

        for (int i=0; i<sizeOfBoard ; i++){
            int currentIndexOfEmptyTile = 0;
            for (int j =0 ;j< sizeOfBoard; j++){
                if (board[j][i] != 0 ){
                    if (board[currentIndexOfEmptyTile][i] == 0){
                        board[currentIndexOfEmptyTile][i] = board[j][i];
                        board[j][i] = 0;
                        currentIndexOfEmptyTile++;
                    }
                    else{
                        currentIndexOfEmptyTile++;
                    }
                }
            }
        }

    }

    public boolean mergeTilesInTopDirection(){

        for (int i=0 ; i < sizeOfBoard; i++){
            for (int j = 0; j < sizeOfBoard -1; j++){
                if (board[j][i] == board[j+1][i]  && board[j][i]!=0){
                    board[j][i]  = 2*board[j][i];
                    board[j+1][i] = 0;
                    decreaseOccupiedTilesCount();
                }
            }
        }
        removeSpacesInTopDirection();
        return hasPlayerWonTheGame();
    }

    public int bottomSlide(){
        removeSpacesInBottomDirection();
        boolean status = mergeTilesInBottomDirection();
        if(status == true){
            printBoard();
            return 1;
        }
        return afterMergeProcess();
    }

    public void removeSpacesInBottomDirection(){

        for (int i=0; i<sizeOfBoard ; i++){
            int currentIndexOfEmptyTile = sizeOfBoard-1;
            for (int j = sizeOfBoard-1 ;j >= 0; j--){
                if (board[j][i] != 0 ){
                    if (board[currentIndexOfEmptyTile][i] == 0){
                        board[currentIndexOfEmptyTile][i] = board[j][i];
                        board[j][i] = 0;
                        currentIndexOfEmptyTile--;
                    }
                    else{
                        currentIndexOfEmptyTile--;
                    }
                }
            }
        }

    }

    public boolean mergeTilesInBottomDirection(){

        for (int i=0 ; i < sizeOfBoard; i++){
            for (int j = sizeOfBoard-1; j >0; j--){
                if (board[j][i] == board[j-1][i]  && board[j][i]!=0){
                    board[j][i]  = 2*board[j][i];
                    board[j-1][i] = 0;
                    decreaseOccupiedTilesCount();
                }
            }
        }
        removeSpacesInBottomDirection();
        return hasPlayerWonTheGame();
    }

    public boolean hasPlayerWonTheGame(){
        for (int i=0; i< sizeOfBoard; i++){
            for (int j=0 ; j< sizeOfBoard ; j++){
                if (board[i][j] == winningNumber){
                    return true;
                }
            }
        }
        return false;
    }

    public int afterMergeProcess(){
        if (totalOccupiedTiles != sizeOfBoard*sizeOfBoard) {
            addRandomTileToTheBoard();
        }
        if(totalOccupiedTiles == sizeOfBoard*sizeOfBoard){
            boolean status = canGameBePlayedFurther();
            if (status == false){
                printBoard();
                return 0;
            }
        }
        printBoard();
        return 2;
    }

    public boolean canGameBePlayedFurther(){

        if (isItPossibleToSlideEitherLeftOrRight()){
            return true;
        }

        if (isItPossibleToSlideEitherTopOrBottom()){
            return true;
        }

        return false;
    }

    public boolean isItPossibleToSlideEitherLeftOrRight(){

        for (int i=0; i<sizeOfBoard; i++){
            for (int j=0; j <sizeOfBoard-1; j++){
                if (board[i][j] == board[i][j+1]){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isItPossibleToSlideEitherTopOrBottom(){

        for (int i=0; i<sizeOfBoard; i++){
            for (int j=0; j <sizeOfBoard-1; j++){
                if (board[j][i] == board[j+1][i]){
                    return true;
                }
            }
        }
        return false;
    }

}
