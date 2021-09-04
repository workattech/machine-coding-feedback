package tictactoe.model;

public class Grid {
    private final int Row;
    private final int Col;
    private int TotalMoves=0;
    private final int RandomLargeNumber=1000;
    String[][] grid= new String[RandomLargeNumber][RandomLargeNumber];
    public Grid(int Row, int Col) {
        this.Row = Row;
        this.Col = Col;
        InitialiseGrid(Row,Col);
        PrintGrid();
    }
    public void InitialiseGrid(int Row,int Col){
        for(int i=0;i<Row;i++){
            for(int j=0;j<Col;j++){
                grid[i][j]="-";
            }
        }
    }
    public void PrintGrid(){
        for(int i=0;i<Row;i++){
            for(int j=0;j<Col;j++){
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }
    }
    public boolean SetGrid(int Row,int Col,String PieceValue){
        if(IsValidMove(Row,Col)){
            grid[Row][Col]=PieceValue;
            PrintGrid();
            TotalMoves++;
            return true;
        }else{
            System.out.println("Invalid Move");
            return false;
        }
    }
    public boolean IsValidMove(int Row,int Col){
        if(Row>this.Row || Row<0)return false;
        if(Col>this.Col  || Col<0)return false;
        return grid[Row][Col].equals("-");
    }
    public boolean isPieceRightDiagonalWinner(String Piece){
        for(int i=0,j=Col-1;i<Row && j>=0;i++,j--){
            if(!grid[i][j].equals(Piece))return false;
        }
        return true;
    }
    public boolean isPieceLeftDiagonalWinner(String Piece){
        for(int i=0,j=0;i<Row && j<Col;i++,j++){
            if(!grid[i][j].equals(Piece))return false;
        }
        return true;
    }
    public boolean isPieceRowWinner(String Piece){
        for(int i=0;i<Row;i++){
            boolean RowFlag=true;
            for(int j=0;j<Col;j++){
                if (!grid[i][j].equals(Piece)) {
                    RowFlag = false;
                    break;
                }
            }
            if(RowFlag)return true;
        }
        return false;
    }
    public boolean isPieceColumnWinner(String Piece){
        for(int i=0;i<Col;i++){
            boolean ColFlag=true;
            for(int j=0;j<Row;j++){
                if(!grid[j][i].equals(Piece)){
                    ColFlag=false;
                    break;
                }
            }
            if(ColFlag)return true;
        }
        return false;
    }
    public boolean IsPieceWinner(String Piece){
        return isPieceRightDiagonalWinner(Piece) || isPieceLeftDiagonalWinner(Piece) || isPieceRowWinner(Piece) || isPieceColumnWinner(Piece);
    }

    public int getTotalMoves() {
        return TotalMoves;
    }

}
