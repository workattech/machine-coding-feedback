package io.shaeli.machinecoding.snakeandladder.models;

import java.util.List;

import io.shaeli.machinecoding.snakeandladder.exceptions.InvalidMoveException;


public class Board {
    private BoardDimension boardDimension;
    private List<SpecialEntity> snakes;
    private List<SpecialEntity> ladders;
    private int numCells;

    int[] positionMapping;

    public Board(BoardDimension boardDimension,
                 List<SpecialEntity> snakes,
                 List<SpecialEntity> ladders) {
        this.boardDimension = boardDimension;
        this.snakes = snakes;
        this.ladders = ladders;
        this.numCells = boardDimension.getRow() * boardDimension.getCol();
        this.positionMapping = new int[this.numCells + 1];
        for(int i=0; i<=this.numCells; i++) positionMapping[i] = i;
        for(SpecialEntity snake : snakes) {
            positionMapping[snake.getStart()] = snake.getEnd();
        }
        for(SpecialEntity ladder : ladders) {
            positionMapping[ladder.getStart()] = ladder.getEnd();
        }
    }

    public int getNumCells() {
        return this.numCells;
    }

    public int getNextPos(int pos, int roll) throws InvalidMoveException {
        if(pos + roll > this.numCells) {
            throw new InvalidMoveException("Invalid move. Cannot move to pos " + pos + roll);
        }
        return positionMapping[pos + roll];
    }
}
