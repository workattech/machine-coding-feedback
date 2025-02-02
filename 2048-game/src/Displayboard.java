public class Displayboard {
    Board board;

    Displayboard(Board board){
        this.board = board;
    }

    public void showOutput(){
        for(int i=0;i<board.size;i++){
            for(int j=0;j<board.size;j++){
                System.out.print(board.tiles[i][j].value + " ");
            }
            System.out.println('\n');
        }
    }
}
