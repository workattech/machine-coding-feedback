package snakesAndLadders.board;

import java.util.Map;

public class Board {
    int size = 100;
    Map<Integer,Integer> snakes;
    Map<Integer,Integer> ladders;
    public Board(Map<Integer,Integer> snakes, Map<Integer,Integer> ladders){
        this.snakes = snakes;
        this.ladders = ladders;
    }
    public int getNextPosition(int position){
        if(snakes.containsKey(position)){
            return snakes.get(position);
        }
        if(ladders.containsKey(position)){
            return ladders.get(position);
        }
        return position;
    }
}
