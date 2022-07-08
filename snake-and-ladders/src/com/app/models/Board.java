package com.app.models;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private int Size;
    private List<Snake> snakes;
    private List<Ladder> ladders;

    int getSize() {
        return Size;
    }

    public Board(int size, List<Snake> snakes, List<Ladder> ladders) {
        Size = size;
        this.snakes = snakes;
        this.ladders = ladders;
    }

    public int updatePlayerPosition(int currentPosition, int movements)
    {
        int newPosition = currentPosition + movements;
        int position = newPosition;
        newPosition = this.checkHeadAndGetSnakeTailPosition(newPosition);
        newPosition = this.checkStartAndGetLadderEndPosition(newPosition);
        return newPosition > this.Size ? currentPosition:newPosition;
    }

    private int checkHeadAndGetSnakeTailPosition(int position)
    {
        for (Snake snake: this.snakes)
        {
            if (snake.headPosition == position)
            {
                return checkHeadAndGetSnakeTailPosition(snake.tailPosition);
            }
        }
        return position;
    }

    private int checkStartAndGetLadderEndPosition(int position)
    {
        for (Ladder ladder: this.ladders)
        {
            if (ladder.startPosition == position)
                return checkStartAndGetLadderEndPosition(ladder.endPosition);
        }
        return position;
    }
}
