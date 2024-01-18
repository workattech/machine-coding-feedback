package org.hsharan.components;

import java.util.HashMap;
import java.util.Map;

public class Snake {
    private int start;
    private int end;

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    private static Map<Integer,Snake> snakes = new HashMap<>();

    public Snake(int start, int end) throws Exception{
        if(snakes.containsKey(start) && Ladder.getLadder(start)!=null){
            throw new Exception("Can't Add this Snake as start position is already occupied");
        }
        this.start = start;
        this.end = end;

            snakes.put(start,this);
    }

    public static Snake getSnake(int start){
        return snakes.get(start);
    }
}
