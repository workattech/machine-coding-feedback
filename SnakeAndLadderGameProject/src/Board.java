public class Board {
    ISpecialMove[] board;
    int size;
    public Board(int size)
    {
        this.size=size;
        board = new ISpecialMove[size+1];
    }
    public void addSpecialMove(ISpecialMove specialObject)
    {
        board[specialObject.start]=specialObject;
    }
}
