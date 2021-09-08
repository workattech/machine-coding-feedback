package tictactoe.model;

public class Grid {
    private final int row;
    private final int col;
    private int totalMoves =0;
    private final int randomLargeNumber =1000;
    String[][] grid= new String[randomLargeNumber][randomLargeNumber];
    public Grid(int row, int col) {
        this.row = row;
        this.col = col;
        InitialiseGrid(row,col);
        printGrid();
    }
    public void InitialiseGrid(int Row,int Col){
        for(int i=0;i<Row;i++){
            for(int j=0;j<Col;j++){
                grid[i][j]="-";
            }
        }
    }
    public void printGrid(){
        for(int i = 0; i< row; i++){
            for(int j = 0; j< col; j++){
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }
    }
    public boolean setGrid(int row, int col, String pieceValue){
        if(isValidMove(row,col)){
            grid[row][col]=pieceValue;
            printGrid();
            totalMoves++;
            return true;
        }else{
            System.out.println("Invalid Move");
            return false;
        }
    }
    public boolean isValidMove(int row, int col){
        if(row>this.row || row<0)return false;
        if(col>this.col || col<0)return false;
        return grid[row][col].equals("-");
    }
    public boolean isPieceRightDiagonalWinner(String Piece){
        for(int i = 0, j = col -1; i< row && j>=0; i++,j--){
            if(!grid[i][j].equals(Piece))return false;
        }
        return true;
    }
    public boolean isPieceLeftDiagonalWinner(String Piece){
        for(int i = 0, j = 0; i< row && j< col; i++,j++){
            if(!grid[i][j].equals(Piece))return false;
        }
        return true;
    }
    public boolean isPieceRowWinner(String piece){
        for(int i = 0; i< row; i++){
            boolean rowFlag=true;
            for(int j = 0; j< col; j++){
                if (!grid[i][j].equals(piece)) {
                    rowFlag = false;
                    break;
                }
            }
            if(rowFlag)return true;
        }
        return false;
    }
    public boolean isPieceColumnWinner(String piece){
        for(int i = 0; i< col; i++){
            boolean colFlag=true;
            for(int j = 0; j< row; j++){
                if(!grid[j][i].equals(piece)){
                    colFlag=false;
                    break;
                }
            }
            if(colFlag)return true;
        }
        return false;
    }
    public boolean IsPieceWinner(String piece){
        return isPieceRightDiagonalWinner(piece) || isPieceLeftDiagonalWinner(piece) || isPieceRowWinner(piece) || isPieceColumnWinner(piece);
    }

    public int getTotalMoves() {
        return totalMoves;
    }

}
