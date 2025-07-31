import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Board {
    private final Map<Integer, Integer> snakes = new HashMap<>();
    private final Map<Integer, Integer> ladders = new HashMap<>();
    private final int boardSize;

    public Board(List<Snake> snakeList, List<Ladder> ladderList, int boardSize){
        this.boardSize = boardSize;
        for(Snake s : snakeList){
            snakes.put(s.getHead(), s.getTail());
        }
        for(Ladder l : ladderList){
            ladders.put(l.getStart(), l.getEnd());
        }
    }

    public int getBoardSize() {
        return boardSize;
    }

    public int getNextPosition(int currentPosition) {
        int newPos = currentPosition;

        //handle snake and ladder logic
        boolean moved;
        do {
            moved = false;
            if(ladders.containsKey(newPos)){
                newPos = ladders.get(newPos);
                moved = true;
            } else if(snakes.containsKey(newPos)){
                newPos = snakes.get(newPos);
                moved = true;
            }
        } while (moved);

        return newPos;
    }
}
