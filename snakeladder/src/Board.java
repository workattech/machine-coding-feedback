import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Board {
    Map<Integer , Integer >  snakesPosition, ladderPosition;

    public Board(List<Snake >snakes , List<Ladder > ladders){
        snakesPosition = new HashMap<>();
        ladderPosition = new HashMap<>();

        for(Snake snake : snakes){
            snakesPosition.put(snake.getHead(), snake.getTail());
        }


        for(Ladder ladder : ladders){
            ladderPosition.put(ladder.getFrom(), ladder.getTo());
        }
    }





}
