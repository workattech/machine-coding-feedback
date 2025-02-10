package Entities;

import java.util.ArrayList;
import java.util.List;

public class Game {
    Grid grid ;

    public Game(int Row,int Col){
        grid = new Grid(Row,Col);
    }

    public Grid getGrid() {
        return grid;
    }

    public void InitialiseGrid(int row,int col){
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                grid.setboard(i,j);
            }
        }
    }
    public void printGrid(int row,int col){
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                System.out.print(grid.getboard(i,j));
                System.out.print(" ");
            }
            System.out.println();
        }
        System.out.println();
    }

    // Main logic to check
    public boolean gridCheck(int rowNo,int colNo,int row,int col,char ch){
        boolean rowCheck= true;
        for(int j=0;j<col;j++){
            if(grid.getboard(rowNo,j)!=ch){
                rowCheck=false;
                break;
            }
        }
        if(rowCheck) return true;

        boolean colCheck = true;
        for(int i=0;i<row;i++){
            if(grid.getboard(i,colNo)!=ch){
                colCheck=false;
                break;
            }
        }
        if(colCheck) return true;

        boolean diagonalCheck1 = true;
        int flag1=0;

        if(rowNo==colNo){
            flag1=1;
            for(int i=0;i<row;i++){
                int flag2=0;
                for(int j=0;j<col;j++){
                    if(i==j){
                        if(grid.getboard(i,j)!=ch){
                            diagonalCheck1=false;
                            flag2=1;
                            break;
                        }
                    }
                }
                if(flag2==1)break;
            }
        }
        if(flag1==1){
            if(diagonalCheck1) return true;
        }

        boolean diagonalCheck2 = true;
        int flag2=0;

        if(rowNo+colNo==row-1){
            flag2=1;
            for(int i=0;i<row;i++){
                int flag3=0;
                for(int j=0;j<col;j++){
                    if(i+j==row-1){
                        if(grid.getboard(i,j)!=ch){
                            diagonalCheck2=false;
                            flag3=1;
                            break;
                        }
                    }
                }
                if(flag3==1)break;
            }
        }
        if(flag2==1){
            if(diagonalCheck2) return true;
        }

        return false;
    }

    public boolean spaceCheck(int row,int col){
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid.getboard(i,j)=='-')return true;
            }
        }
        return false;
    }
}
