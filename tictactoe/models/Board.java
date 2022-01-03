package tictactoe.tictactoePackage.models;

public class Board {

    private int sizeOfBoard;
    private Character  board[][];

    public Board(int sizeOfBoard){
        this.sizeOfBoard = sizeOfBoard;
        this.board = new Character [sizeOfBoard][sizeOfBoard];
    }

    public void setPieceAtBoard(int currentRow, int currentColumn, Character  currentPiece) {
        if(isPieceAtValidCell(currentRow, currentColumn)){
            board[currentRow][currentColumn] = currentPiece;
        }
        else{
            System.out.println("Invalid Move");
        }
    }

    public void initializeTheBoard(){
        for (int i=0;i<sizeOfBoard;i++){
            for (int j=0;j<sizeOfBoard;j++){
                board[i][j] = '-';
            }
        }
    }

    public void printBoard(){
        for (int i=0;i<sizeOfBoard;i++){
            for (int j=0;j<sizeOfBoard;j++){
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

    public boolean isPieceAtValidCell(int currentRow, int currentColumn){
        if(currentRow<0 || currentRow>= sizeOfBoard) {
            return false;
        }
        if(currentColumn<0 || currentColumn>= sizeOfBoard) {
            return false;
        }
        if(board[currentRow][currentColumn] != '-') return false;
        return true;
    }

    public boolean HasPlayerWonTheGame(int currentRow, int currentColumn){

        boolean status = true;
        for(int i=0; i<sizeOfBoard;i++){
            if(board[currentRow][i] != board[currentRow][currentColumn]){
                status = false;
                break;
            }
        }
        if(status == true) return true;
        status = true;

        for(int i=0; i<sizeOfBoard;i++){
            if(board[i][currentColumn] != board[currentRow][currentColumn]) {
                status =  false;
                break;
            }
        }
        if(status == true) return true;

        if(currentColumn == currentRow){
            status = true;
            for (int i=0; i<sizeOfBoard;i++){
                if(board[i][i]!=board[currentRow][currentColumn]){
                    status =  false;
                    break;
                }
            }
        }
        if(status == true) return true;

        if(currentRow + currentColumn == sizeOfBoard -1){
            status = true;
            int row = 0, col = sizeOfBoard-1;
            for(int i=0;i<sizeOfBoard;i++){
                if(board[row][col]!=board[currentRow][currentColumn]){
                    status =  false;
                    break;
                }
                row++;
                col--;
            }
        }
        if(status == true) return true;
        return  false;
    }

}