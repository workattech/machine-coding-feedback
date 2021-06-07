package TwoZeroFourEight;

import java.util.Random;

public class GameBoardServiceUtil {

    public int getRandom(int number)
    {
        Random random = new Random();
        return random.nextInt(number);
    }

    public int getNumberOfEmptyCells(GameBoard board)
    {
        int count = 0;
        for(int row=0;row<board.getTotalRows();row++)
        {
            for(int col=0;col<board.getTotalCols();col++)
            {
                if(board.getGameBoardCellValue(row,col)=="-")
                {
                    count++;
                }
            }
        }
        return count;
    }

    public void showBoard(GameBoard gameBoard)
    {
        for(int row = 0; row < gameBoard.getTotalRows() ; row++)
        {
            for(int col = 0; col < gameBoard.getTotalCols() ; col++)
            {
                System.out.print(gameBoard.getGameBoardCellValue(row,col) + ' ');
            }
            System.out.println();
        }
        System.out.println();
    }

    public String getCellValue(String actualCellValue,String otherCellValue)
    {
        if(actualCellValue == "-"){
            return otherCellValue;
        }
        int actualCellVal = Integer.parseInt(actualCellValue);
        int otherCellVal = Integer.parseInt(otherCellValue);
        int sum = actualCellVal + otherCellVal;
        return String.valueOf(sum);
    }

}
