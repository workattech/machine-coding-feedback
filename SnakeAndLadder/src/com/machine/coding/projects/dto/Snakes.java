package com.machine.coding.projects.dto;

import java.util.Map;

public class Snakes {

    private Map<Integer, Integer> positions;

    public Snakes(Map positions) {
        this.positions = positions;
    }

    public int getPositions(int val) {
        if (positions.containsKey(val)) {
            return positions.get(val);
        } else {
            return -1;
        }
    }

}
