package TwoZeroFourEight;

import TwoZeroFourEight.GameBoard;
import java.util.Random;

public class GameBoardService extends GameBoard {
    private int totalRows;
    private int totalCols;
    private static String final_board_val = "2048";
    private Boolean isGameWon;
    private Boolean isGameLost;
    private Boolean isFirstAllocation;
    private GameBoardServiceUtil util;

    GameBoardService()
    {
        super();
        this.totalRows = this.getTotalRows();
        this.totalCols = this.getTotalCols();
        this.isFirstAllocation = true;
        this.isGameWon = false;
        this.isGameLost = false;
        this.util = new GameBoardServiceUtil();
    }

    public Boolean getGameWon() {
        return isGameWon;
    }

    public Boolean getGameLost() {
        return isGameLost;
    }

    public void setGameWon(Boolean gameWon) {
        isGameWon = gameWon;
    }

    public void setGameLost(Boolean gameLost) {
        isGameLost = gameLost;
    }

    void randomAllocateCellUtil(int position)
    {
        int positionCount = 0;
        Boolean isAllocated = false;
        for(int row = 0; row < this.getTotalRows(); row++)
        {
            for(int col = 0; col < this.getTotalCols(); col++)
            {
                if(this.getGameBoardCellValue(row,col)=="-"){
                    if(positionCount == position) {
                        this.setGameBoardCellValue(row, col, "2");
                        isAllocated = true;
                        break;
                    }
                    positionCount++;
                }
            }
            if(isAllocated){
                break;
            }
        }
    }

    void checkGameWon(String val)
    {
        if(val == final_board_val){
            this.setGameWon(true);
        }
    }

    void randomAllocate()
    {
        int numberOfEmptyCells;
        if(this.isFirstAllocation==true) {
            numberOfEmptyCells = this.getTotalRows() * this.getTotalCols();
            randomAllocateCellUtil(util.getRandom(numberOfEmptyCells));
            randomAllocateCellUtil(util.getRandom(numberOfEmptyCells-1));
            this.isFirstAllocation = false;
        }else{
            numberOfEmptyCells = util.getNumberOfEmptyCells(this);
            if(numberOfEmptyCells != 0) {
                randomAllocateCellUtil(util.getRandom(numberOfEmptyCells));
            }else{
                this.setGameLost(true);
            }
        }
    }

    public void startGame()
    {
        this.randomAllocate();
        util.showBoard(this);
    }

    public void playMove(String move)
    {
        switch (move)
        {
            case "0":
                this.moveLeft();
                this.randomAllocate();
                break;
            case "1":
                this.moveRight();
                this.randomAllocate();
                break;
            case "2":
                this.moveTop();
                this.randomAllocate();
                break;
            case "3":
                this.moveBottom();
                this.randomAllocate();
                break;
            default:
                System.out.println("invalid move");
        }
        util.showBoard(this);
    }

    public void moveRight()
    {
        int total_col = this.getTotalCols()-1;
        int total_row = this.getTotalRows()-1;
        int col = total_col - 1;
        while(col >= 0)
        {
            for(int row = 0;row <= total_row;row++)
            {
                int final_col = total_col;
                while(final_col > col)
                {
                    if(this.getGameBoardCellValue(row,final_col)=="-" || this.getGameBoardCellValue(row,col).equalsIgnoreCase(this.getGameBoardCellValue(row,final_col))) {
                        this.setGameBoardCellValue(row, final_col, util.getCellValue(this.getGameBoardCellValue(row, final_col), this.getGameBoardCellValue(row, col)));
                        this.setGameBoardCellValue(row,col,"-");
                        this.checkGameWon(this.getGameBoardCellValue(row,final_col));
                        break;
                    }
                    final_col--;
                }
            }
            col--;
        }
    }

    public void moveLeft()
    {
        int total_col = this.getTotalCols() - 1;
        int start_col = 0;
        int col = start_col+1;
        int total_row = this.getTotalRows() - 1;
        while(col <= total_col)
        {
            for(int row=0;row <= total_row; row++)
            {
                int final_col = 0;
                while(final_col<col)
                {
                    if(this.getGameBoardCellValue(row,final_col)=="-" || this.getGameBoardCellValue(row,final_col).equalsIgnoreCase(this.getGameBoardCellValue(row,col)))
                    {
                        this.setGameBoardCellValue(row,final_col, util.getCellValue(this.getGameBoardCellValue(row,final_col),this.getGameBoardCellValue(row,col)));
                        this.setGameBoardCellValue(row,col,"-");
                        this.checkGameWon(this.getGameBoardCellValue(row,final_col));
                        break;
                    }
                    final_col++;
                }
            }
            col++;
        }
    }

    public void moveTop()
    {
        int total_rows = this.getTotalRows() - 1;
        int total_cols = this.getTotalCols() - 1;
        int start_row = 0;
        int row = start_row + 1;
        while (row <= total_rows)
        {
            for(int col=0; col <= total_cols ; col++)
            {
                int final_row = 0;
                while(final_row<row) {
                    if (this.getGameBoardCellValue(final_row, col) == "-" || this.getGameBoardCellValue(final_row, col).equalsIgnoreCase(this.getGameBoardCellValue(row, col)))
                    {
                        this.setGameBoardCellValue(final_row, col, util.getCellValue(this.getGameBoardCellValue(final_row, col), this.getGameBoardCellValue(row, col)));
                        this.setGameBoardCellValue(row,col,"-");
                        this.checkGameWon(this.getGameBoardCellValue(final_row, col));
                        break;
                    }
                    final_row++;
                }
            }
            row++;
        }
    }

    public void moveBottom()
    {
        int total_rows = this.getTotalRows() - 1;
        int total_cols = this.getTotalCols() - 1;
        int row = total_rows - 1;

        while(row >= 0)
        {
            for(int col=0; col <= total_cols; col++) {
                int final_row = total_rows;
                while(final_row >= row) {
                    if(this.getGameBoardCellValue(final_row,col)=="-" || this.getGameBoardCellValue(final_row,col).equalsIgnoreCase(this.getGameBoardCellValue(row,col)))
                    {
                        this.setGameBoardCellValue(final_row,col,util.getCellValue(this.getGameBoardCellValue(final_row,col),this.getGameBoardCellValue(row,col)));
                        this.setGameBoardCellValue(row,col,"-");
                        checkGameWon(this.getGameBoardCellValue(final_row,col));
                        break;
                    }
                    final_row--;
                }
            }
            row--;
        }
    }


}
