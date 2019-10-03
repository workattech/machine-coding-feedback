public class Board {
    IBlock[] board;
    int size;
    public Board(int size)
    {
        this.size=size;
        board = new IBlock[size+1];
    }
    public void addSnakeOrLadder(IBlock specialObject)
    {
        board[specialObject.start]=specialObject;
    }
}
