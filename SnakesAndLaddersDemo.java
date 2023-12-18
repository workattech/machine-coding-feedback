import java.io.*;
import java.util.*;
class SnakesAndLaddersDemo {
    public static void main(String[] args) {
        int nSnakes=9;
        int[][] snakes=new int[][]{
            {62, 5},
            {33, 6},
            {49, 9},
            {88, 16},
            {41, 20},
           { 56, 53},
            {98, 64},
           { 93, 73},
            {95, 75}
        };
        int nLadders=8;
        int[][] ladders=new int[][]{
            {2, 37},
            {27, 46},
            {10, 32},
            {51, 68},
           { 61, 79},
           { 65, 84},
            {71, 91},
            {81, 100}
        };
        int nPlayers=2;
        String[] players=new String[]{"A", "B", "C"};

        SnakesAndLadders gamSnakesAndLadders=new SnakesAndLadders(players, snakes, ladders);
        gamSnakesAndLadders.playGame();
    }
}