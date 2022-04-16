package Services;

import java.util.*;

import Models.*;

public class BoardService {
    private Board board;
    
    BoardService(Board board) {
        this.board = board;
    }

    int getSize() {
        return this.board.getSize();
    }

    boolean validPosition(int position) {
        return position <= this.board.getSize();
    }

    public boolean isSnakeOrLadderAt(int position) {
        ArrayList<Snake> snakes = this.board.getSnakes();
        for(int currIdx = 0; currIdx < snakes.size(); currIdx++) {
            if(position == snakes.get(currIdx).getHead()) {
                return true;
            }
        }
        ArrayList<Ladder> ladders = this.board.getLadders();
        for(int currIdx = 0; currIdx < ladders.size(); currIdx++) {
            if(position == ladders.get(currIdx).getStart()) {
                return true;
            }
        }
        return false;
    }

    int getNewPosition(int currPosition) {
        ArrayList<Snake> snakes = this.board.getSnakes();
        for(int currIdx = 0; currIdx < snakes.size(); currIdx++) {
            if(currPosition == snakes.get(currIdx).getHead()) {
                return snakes.get(currIdx).getTail();
            }
        }
        ArrayList<Ladder> ladders = this.board.getLadders();
        for(int currIdx = 0; currIdx < ladders.size(); currIdx++) {
            if(currPosition == ladders.get(currIdx).getStart()) {
                return ladders.get(currIdx).getEnd();
            }
        }
        return currPosition;
    }
}