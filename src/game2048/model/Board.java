package game2048.model;

public class Board {
    int boardSideHeight;
    int boardSideWidth;
    int winningValue;
    String[][] board;
     public Board(int height,int width,int winningValue){
         this.winningValue=winningValue;
         boardSideHeight=height;
         boardSideWidth=width;
         board=new String[boardSideHeight][boardSideWidth];
         initializeBoard();
         randomTileInserter();
         randomTileInserter();
         printBoard(height,width);
    }
    public int getBoardSideHeight() {
        return boardSideHeight;
    }

    public void setBoardSideHeight(int boardSideLength) {
        this.boardSideHeight = boardSideLength;
    }

    public int getBoardSideWidth() {
        return boardSideWidth;
    }

    public void setBoardSideWidth(int boardSideWidth) {
        this.boardSideWidth = boardSideWidth;
    }

    public int getWinningValue() {
        return winningValue;
    }

    public void setWinningValue(int winningValue) {
        this.winningValue = winningValue;
    }

    public String[][] getBoard() {
        return board;
    }

    public void setBoard(String[][] board) {
        this.board = board;
    }
    public void initializeBoard(){
        for(int i=0;i<getBoardSideHeight();i++){
            for(int j=0;j<getBoardSideWidth();j++){
                board[i][j]="-";
            }
        }
    }
    public void removeSpaceInTopDirection(int height, int width){
        for(int k=0;k<width;k++){
            int i=0,j=0;
            while(j<height){
                if(!board[j][k].equals("-")){
                    board[i][k]=board[j][k];
                    if(i!=j)board[j][k]="-";
                    i++;
                    j++;
                }else{
                    j++;
                }
            }
        }
    }
    public void removeSpaceInBottomDirection(int height,int width){
        for(int k=0;k<width;k++){
            int i=height-1,j=height-1;
            while(j>=0){
                if(!board[j][k].equals("-")){
                    board[i][k]=board[j][k];
                    if(i!=j)board[j][k]="-";
                    i--;
                    j--;
                }else{
                    j--;
                }
            }
        }
    }
    public void removeSpaceInLeftDirection(int height,int width){
        for(int k=0;k<height;k++){
            int i=0,j=0;
            while(j<width){
                if(!board[k][j].equals("-")){
                    board[k][i]=board[k][j];
                    if(i!=j)board[k][j]="-";
                    i++;
                    j++;
                }else{
                    j++;
                }
            }
        }
    }
    public void removeSpaceInRightDirection(int height,int width){
        for(int k=0;k<height;k++){
            int i=width-1,j=width-1;
            while(j>=0){
                if(!board[k][j].equals("-")){
                    board[k][i]=board[k][j];
                    if(i!=j)board[k][j]="-";
                    i--;
                    j--;
                }else{
                    j--;
                }
            }
        }
    }
    public void mergeInTopDirection(int height,int width){
        for(int k=0;k<width;k++){
            for(int i=0;i<height-1;i++){
                if(board[i][k].equals(board[i+1][k]) && !board[i][k].equals("-") ){
                    board[i][k]=""+2*Integer.parseInt(board[i][k]);
                    board[i+1][k]="-";
                }
            }
        }
    }
    public void mergeInLeftDirection(int height,int width){
        for(int k=0;k<height;k++){
            for(int i=0;i<width-1;i++){
                if(board[k][i].equals(board[k][i+1]) && !board[k][i].equals("-") ){
                    board[k][i]=""+2*Integer.parseInt(board[k][i]);
                    board[k][i+1]="-";
                }
            }
        }
    }
    public void mergeInRightDirection(int height,int width){
        for(int k=0;k<height;k++){
            for(int i=width-1;i>0;i--){
                if(board[k][i].equals(board[k][i-1]) && !board[k][i].equals("-") ){
                    board[k][i]=""+2*Integer.parseInt(board[k][i]);
                    board[k][i-1]="-";
                }
            }
        }
    }
    public void mergeInBottomDirection(int height,int width){
        for(int k=0;k<width;k++){
            for(int i=height-1;i>0;i--){
                if(board[i][k].equals(board[i-1][k]) && !board[i][k].equals("-") ){
                    board[i][k]=""+2*Integer.parseInt(board[i][k]);
                    board[i-1][k]="-";
                }
            }
        }
    }
    public boolean isGameWon(int height,int width){
        for(int i=0;i<height;i++){
            for(int j=0;j<width;j++){
                if(board[i][j].equals(""+winningValue)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean isGameLost(int height,int width){
        for(int i=0;i<height;i++){
            for(int j=0;j<width;j++){
                if(board[i][j].equals("-")){
                   return false;
                }
            }
        }
        return true;
    }
    public int randomNumberGenerator(int val){
            return (int)(Math.random()*(val)+1);//used to get random number in range[1,val]

    }
    public void printBoard(int height,int width){
        for(int i=0;i<height;i++){
            for(int j=0;j<width;j++){
                System.out.print(board[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
    public void randomTileInserter(){
        boolean done=false;
        int val=randomNumberGenerator(2);
        int numberToBeInserted;
        if(val==1){
            numberToBeInserted=2;
        }else{
            numberToBeInserted=4;
        }
        while(!done){
            int height=getBoardSideHeight();
            int width=getBoardSideWidth();
            int row=randomNumberGenerator(height);
            int col=randomNumberGenerator(width);
            if(board[row-1][col-1].equals("-")){
                board[row-1][col-1]=""+numberToBeInserted;
                done=true;

            }
        }


    }
}
