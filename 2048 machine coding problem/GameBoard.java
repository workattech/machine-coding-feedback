package TwoZeroFourEight;

public class GameBoard {
    private static int DEFAULT_ROW = 4;
    private static int DEFAULT_COL = 4;
    private String [][] board;
    GameBoard()
    {
        this.board = new String[DEFAULT_ROW][DEFAULT_COL];
        for(int row=0;row<DEFAULT_ROW;row++)
        {
            for(int col=0;col<DEFAULT_COL;col++)
            {
                board[row][col] = "-";
            }
        }
    }

    public String[][] getBoard() {
        return board;
    }

    public int getTotalRows()
    {
        return DEFAULT_ROW;
    }

    public int getTotalCols()
    {
        return DEFAULT_COL;
    }

    public String getGameBoardCellValue(int row,int col)
    {
        return this.board[row][col];
    }

    public void setGameBoardCellValue(int row,int col,String val)
    {
        this.board[row][col] = val;
    }

}
