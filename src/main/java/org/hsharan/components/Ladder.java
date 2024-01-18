package org.hsharan.components;

import java.util.HashMap;
import java.util.Map;

public class Ladder {
    private int start;
    private int end;

    private static Map<Integer,Ladder> ladders=new HashMap<>();

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

    public Ladder(int start, int end) throws Exception {
        if(ladders.containsKey(start) && Snake.getSnake(start)!=null){
            throw new Exception("Can't Add this Snake as start position is already occupied");
        }
        this.start = start;
        this.end = end;
        ladders.put(start,this);
    }

    public static Ladder getLadder(int start){
        return ladders.get(start);
    }
}
