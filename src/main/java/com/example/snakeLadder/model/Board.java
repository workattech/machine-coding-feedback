package com.example.snakeLadder.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;
import java.util.List;

@Data
@AllArgsConstructor
public class Board {
    private int size;
    private List<Ladder> ladders;
    private List<Snake> snakes;
    private HashMap<Integer, Integer> playerPositions;
}
