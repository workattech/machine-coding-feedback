import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Game {
    Board board;
    int direction;
    int size ;
    Displayboard displayboard;
    boolean flag = false;
    int filledTiles = 0;
    ArrayList<Integer> tileValueList;

    Scanner scanner = new Scanner(System.in);

    Game(Board board){
        this.board = board;
        size = board.size;
        tileValueList = new ArrayList<Integer>(Arrays.asList(2,4));
        displayboard = new Displayboard(board);
    }

    public void startGame(Board board){
        displayboard.showOutput();
        while (filledTiles < size*size && flag == false) {
            direction = scanner.nextInt();
            if(direction == 3){
                slideBottom();
            }
            else if(direction == 2){
                slideUp();
            }
            else if(direction == 1){
                slideRight();
            }
            else {
                slideLeft();
            }
            insertTile();
            displayboard.showOutput();
            checkGame();
        }
        if(flag == true){
            System.out.println("Congratulations");
        }
        else System.out.println("Game over"); 
    }

    private void insertTile(){
        int add = 0;
        while(add < 1){
            int row = ThreadLocalRandom.current().nextInt(0,size);
            int column = ThreadLocalRandom.current().nextInt(0,size);
            int number = ThreadLocalRandom.current().nextInt(0,tileValueList.size());
            
            if(board.tiles[row][column].value == 0){
                board.tiles[row][column].value = tileValueList.get(number);
                add++;
            }
        }
    }

    private void checkGame(){
        filledTiles = 0;
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                if(board.tiles[i][j].value == 2048){
                    flag = true;
                    break;
                }
                if(board.tiles[i][j].value == 0){
                    break;
                }
                else filledTiles += 1;
            }
        }
    }
    private void slideBottom(){
        for(int j=0;j<size;j++){
            int end = size-1;
            for(int i=size-1;i>=0;i--){
                int k = i;
                if(board.tiles[i][j].value > 0){
                    while(k < end){
                        if(board.tiles[k+1][j].value > 0){
                            if(board.tiles[k+1][j].value != board.tiles[k][j].value){
                                end = k;
                                break;
                            }
                            else {
                                board.tiles[k+1][j].value += board.tiles[k][j].value;
                                board.tiles[k][j].value = 0;
                                end = k+1;
                            }
                        }
                        else {
                            board.tiles[k+1][j].value = board.tiles[k][j].value;
                            board.tiles[k][j].value = 0;
                        }
                        k++;
                    }
                }
            }
        }
    }

    private void slideUp(){
        for(int j=0;j<size;j++){
            int end = 0;
            for(int i=0;i<size;i++){
                int k = i;
                if(board.tiles[i][j].value > 0){
                    while(k > end){
                        if(board.tiles[k-1][j].value > 0){
                            if(board.tiles[k-1][j].value != board.tiles[k][j].value){
                                end = k;
                                break;
                            }
                            else {
                                board.tiles[k-1][j].value += board.tiles[k][j].value;
                                board.tiles[k][j].value = 0;
                                end = k-1;
                            }
                        }
                        else {
                            board.tiles[k-1][j].value = board.tiles[k][j].value;
                            board.tiles[k][j].value = 0;
                        }
                        k--;
                    }
                }
            }
        }
    }

    private void slideRight(){
        for(int i=0;i<size;i++){
            int end = size-1;
            for(int j=size-1;j>=0;j--){
                int k = j;
                if(board.tiles[i][j].value > 0){
                    while(k < end){
                        if(board.tiles[i][k+1].value > 0){
                            if(board.tiles[i][k+1].value != board.tiles[i][k].value){
                                end = k;
                                break;
                            }
                            else {
                                board.tiles[i][k+1].value += board.tiles[i][k].value;
                                board.tiles[i][k].value = 0;
                                end = k+1;
                            }
                        }
                        else {
                            board.tiles[i][k+1].value = board.tiles[i][k].value;
                            board.tiles[i][k].value = 0;
                        }
                        k++;
                    }
                }
            }
        }
    }

    private void slideLeft(){
        for(int i=0;i<size;i++){
            int end = 0;
            for(int j=0;j< size;j++){
                int k = j;
                if(board.tiles[i][j].value > 0){
                    while(k > end){
                        if(board.tiles[i][k-1].value > 0){
                            if(board.tiles[i][k-1].value != board.tiles[i][k].value){
                                end = k;
                                break;
                            }
                            else {
                                board.tiles[i][k-1].value += board.tiles[i][k].value;
                                board.tiles[i][k].value = 0;
                                end = k-1;
                            }
                        }
                        else {
                            board.tiles[i][k-1].value = board.tiles[i][k].value;
                            board.tiles[i][k].value = 0;
                        }
                        k--;
                    }
                }
            }
        }
    }
}
