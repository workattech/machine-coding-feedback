public class Player {
    int pos;
    String name;
    public Player(String name)
    {
        pos=0;
        this.name=name;
    }

    public void move(Board gameBoard, int dice) {
        int curPos=pos+dice;
        if(curPos>(gameBoard.size))
        {
            System.out.println(name+" rolled a "+dice+" and moved from"+pos+" to"+pos);
            return;
        }
        else
        {
            if(gameBoard.board[curPos]!=null)
                curPos=gameBoard.board[curPos].end;
            System.out.println(name+" rolled a "+dice+" and moved from"+pos+" to"+curPos);
            pos=curPos;
        }
    }
}
