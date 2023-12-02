import java.util.Map;

public class Board {
    private int numRows;
    private int numCols;

    Map<Integer,Integer> snakes ;
    Map<Integer,Integer> ladders;

    public Board(int numRows, int numCols, Map<Integer,Integer> snakes, Map<Integer,Integer> ladders){
        this.numRows = numRows;
        this.numCols = numCols;
        this.snakes = snakes;
        this.ladders = ladders;
    }

    private boolean isLadderPresent(int position){
        return ladders!=null && ladders.containsKey((position));
    }

    private int getLadderTop(int position){
        if(isLadderPresent((position))){
            return ladders.get(position);
            //ladders.getOrDefault(position, -1);
        }
        return -1;
    }

    private boolean isSnakePresent(int position){
        return snakes!=null && snakes.containsKey((position));
    }

    private int getSnakeTail(int position){
        if(isSnakePresent((position))){
            return snakes.get(position);
            //snakes.getOrDefault(position, -1);
        }
        return -1;
    }

    private boolean isValidMove(int position){
        return position <= (numRows*numCols);
    }

    public int getNextPosition(int currPosition, int stepsToMove){
        int nextIdx = currPosition + stepsToMove;
        if(isValidMove(nextIdx)) {
            while(isLadderPresent(nextIdx)){
                nextIdx = getLadderTop(nextIdx);
                //System.out.println("Climbed ladder");
            }
            while(isSnakePresent(nextIdx)){
                nextIdx = getSnakeTail(nextIdx);
                //System.out.println("Bitten by snake");
            }
        }

        return isValidMove(nextIdx) ? nextIdx : -1;
    }
}
