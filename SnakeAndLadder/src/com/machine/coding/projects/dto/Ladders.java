package com.machine.coding.projects.dto;

import java.util.Map;

public class Ladders {

    private Map<Integer, Integer> positions;

    public Ladders(Map positions) {
        this.positions = positions;
    }

    public int getPositions(int x) {
        if (positions.containsKey(x)) {
            return positions.get(x);
        } else {
            return -1;
        }
    }

}
