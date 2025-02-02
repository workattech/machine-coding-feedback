// import java.util.ArrayList;
import java.util.Scanner;

public class Board {
    Cell[][] cells;
    
    // int n = cells.length;
    // int m = cells[0].length;
    Scanner scn =  new Scanner(System.in);

    Board(int boardSize){
        initializeBoard(boardSize);
        addSnakes();
        addLadders();
    }

    private void initializeBoard(int size){
        cells = new Cell[size][size];
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                cells[i][j] = new Cell();
            }
        }
    }

    private void addSnakes(){
        int snakesCount = scn.nextInt();
        while(snakesCount > 0){
            int head = scn.nextInt();
            int tail = scn.nextInt();
            if(head <= tail || head == 100 || getCell(head).jump != null){
                System.err.print("not possible ! Enter again");
            }
            else {
                Jump snakeJump = new Jump();
                snakeJump.start = head;
                snakeJump.end = tail;
                Cell headCell = getCell(head);
                headCell.jump = snakeJump;
                snakesCount--;
            }
        }
    }

    private void addLadders(){
        int laddersCount = scn.nextInt();
        while(laddersCount > 0){
            int start = scn.nextInt();
            int end = scn.nextInt();
            if(start >= end || getCell(start).jump != null){
                System.err.print("not possible ! Enter again");
            }
            else {
                Jump ladderJump = new Jump();
                ladderJump.start = start;
                ladderJump.end = end;
                Cell headCell = getCell(start);
                headCell.jump = ladderJump;
                laddersCount--;
            }
        }
    }

    Cell getCell(int position){
        int row = (position-1)/cells.length;
        int column  = (position-1)%cells.length;
        return cells[row][column];
    }
    
}
