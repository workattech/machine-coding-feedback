import java.util.List;

public class Board {
    
    int size;
    List<Cell>cells;
    List<SnakeLadder> snakeLadders;

    public Board (int size, List<Cell> cells, List<SnakeLadder> snakeLadders)
    {
        this.size = size;
        this.cells = cells;
        this.snakeLadders = snakeLadders;
    }

    public int handleSnakesAndLadders(Player player)
    {
        int currPosition= player.currPosition;
        while(true)
        { 
            boolean updated= false;
            for(int i=0;i<snakeLadders.size();i++)
            {
                int start=snakeLadders.get(i).start;
                int end=snakeLadders.get(i).end;

                if(start == currPosition)
                {
                    updated= true;
                    currPosition = end;
                    break;
                }

            }
            if(updated==false)
            {
                break;
            }
        }
        return currPosition;
    }
}
