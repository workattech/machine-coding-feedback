import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Board {
    private Cell[] mBoard;
    private List<Snake> mSnakes;
    private List<Ladder> mLadders;

    Board() {
        mBoard = new Cell[101];

        initialiseBoard();
    }

    private void initialiseBoard() {
        System.out.println(("initialiseBoard start"));
        for(int i = 0; i < 101; ++i) {
            mBoard[i] = new Cell();
        }

        Scanner scanner = new Scanner(System.in);
        int snakesNum = scanner.nextInt();
        mSnakes = new ArrayList<>();
        while (snakesNum != 0) {
            mSnakes.add(new Snake(scanner.nextInt(), scanner.nextInt()));
            --snakesNum;
        }
        int ladderNum = scanner.nextInt();
        mLadders = new ArrayList<>();
        while (ladderNum != 0) {
            mLadders.add(new Ladder(scanner.nextInt(), scanner.nextInt()));
            --ladderNum;
        }

        for (int i = 0; i < mSnakes.size(); ++i) {
            mBoard[mSnakes.get(i).getHead()].setSnakeId(i);
        }
        for (int i = 0; i < mLadders.size(); ++i) {
            mBoard[mLadders.get(i).getStart()].setLadderId(i);
        }
        System.out.println(("initialiseBoard end Snakes: " + mSnakes.size() + " Ladders: " + mLadders.size()));
    }

    public int getNextPos(int pos) {
        int snakeId = mBoard[pos].getSnakeId();
        int ladderId = mBoard[pos].getLadderId();
        while (snakeId != -1 || ladderId != -1) {
            if (snakeId != -1) {
                pos = mSnakes.get(snakeId).getTail();
            } else {
                pos = mLadders.get(ladderId).getEnd();
            }
            snakeId = mBoard[pos].getSnakeId();
            ladderId = mBoard[pos].getLadderId();
        }
        return pos;
    }
}