package main.java.module;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TicTacToeService {
    TicTacToeBoard ticTacToeBoard = new TicTacToeBoard();
    Queue<Player> playerSequence;

    void setPlayerSequence(List<Player> players){
        this.playerSequence = new LinkedList<>();
        for(Player player : players){
            playerSequence.add(player);
        }
    }
    void initializeBoard(int row,int col){
        ticTacToeBoard.setRow(row);
        ticTacToeBoard.setCol(col);
        ticTacToeBoard.initboard(row, col);

    }
    void setBoardValue(Player player,int row, int col){
        ticTacToeBoard.setBoard(row-1, col-1, player.getSymbol());
    }
    void printBoardValues(){
        for(int i = 0; i < ticTacToeBoard.getRow(); i ++){
            for(int j = 0; j < ticTacToeBoard.getCol(); j++){
                System.out.print(ticTacToeBoard.getBoard(i, j) + " ");
            }
            System.out.println();
        }
    }
    boolean colWiseCheck(){
        int countValueX = 0;
        int countValueO = 0;
        for(int i = 0; i < ticTacToeBoard.getRow(); i++){
            for(int j = 0; j < ticTacToeBoard.getCol(); j++){
                if(ticTacToeBoard.getBoard(j,i) == 'X')
                    countValueX++;
                if(ticTacToeBoard.getBoard(j,i) == 'O')
                    countValueO++;
            }
            if(countValueX == ticTacToeBoard.getCol())
                return true;
            else
                countValueX = 0;
            if(countValueO == ticTacToeBoard.getCol())
                return true;
            else
                countValueO = 0;
        }
        return false;
    }
    boolean rowWiseCheck(){
        int countValueX = 0;
        int countValueO = 0;

        for(int i = 0; i < ticTacToeBoard.getCol(); i++){
            for(int j = 0; j < ticTacToeBoard.getRow(); j++){
                if(ticTacToeBoard.getBoard(i,j) == 'X')
                    countValueX++;
                if(ticTacToeBoard.getBoard(i,j) == 'O')
                    countValueO++;
            }
            if(countValueX == ticTacToeBoard.getCol())
                return true;
            else
                countValueX = 0;
            if(countValueO == ticTacToeBoard.getCol())
                return true;
            else
                countValueO = 0;
        }
        return false;
    }
    boolean leftDiagonalCheck(){
        int countValueX =0;
        int countValueO = 0;
        int leftDiagonal = 0;
        for(int i = 0; i < ticTacToeBoard.getRow(); i++){
            if(ticTacToeBoard.getBoard(i, leftDiagonal) == 'X')
                countValueX++;
            if(ticTacToeBoard.getBoard(i, leftDiagonal) == 'O')
                countValueO ++;
            leftDiagonal++;
        }
        if(countValueO == ticTacToeBoard.getCol() || countValueX == ticTacToeBoard.getCol())
            return true;
        return false;
    }
    boolean rightDiagonalCheck(){
        int countValueX = 0;
        int countValueO =0;
        int rightDiaogal = ticTacToeBoard.getCol()-1;
        for(int i = 0; i < ticTacToeBoard.getRow(); i++){
            if(ticTacToeBoard.getBoard(i, rightDiaogal) == 'X')
                countValueX++;
            if(ticTacToeBoard.getBoard(i,rightDiaogal) == 'O')
                countValueO ++;
            rightDiaogal--;
        }
        if(countValueO == ticTacToeBoard.getCol() || countValueX == ticTacToeBoard.getCol())
            return true;
        return false;
    }
    boolean checkWinner(){
        if(rowWiseCheck() || colWiseCheck() || leftDiagonalCheck() || rightDiagonalCheck())
            return true;
        else
            return false;
    }
    boolean checkValidMove(int row, int col){
        if(row < 1 || row > ticTacToeBoard.getRow() || col < 1 || col > ticTacToeBoard.getCol()){
            return false;
        }
        if((ticTacToeBoard.getBoard(row-1, col-1)) != '-'){
            return false;
        }
        return true;
    }
    void startGame(List<Pieces> pieces) {
        printBoardValues();
        for (Pieces piece : pieces) {

            if (checkValidMove(piece.getRow(), piece.getCol())) {
                Player currentPlayer = playerSequence.poll();
                setBoardValue(currentPlayer, piece.getRow(), piece.getCol());
                if (checkWinner()) {
                    printBoardValues();
                    System.out.println(currentPlayer.getName() + " won the game");
                    return;
                }
                playerSequence.add(currentPlayer);printBoardValues();
            }
            else{
                printBoardValues();
                System.out.println("Invalid Move");
            }
            if (isGameComplete()) {
                System.out.println("Game Over");
                return;
            }


        }
    }

    boolean isGameComplete(){
        for(int i = 0; i < ticTacToeBoard.getRow(); i++){
            for(int j = 0; j < ticTacToeBoard.getCol(); j++){
                if(ticTacToeBoard.getBoard(i,j) == '-')
                    return false;
            }
        }
        return true;
    }
}
