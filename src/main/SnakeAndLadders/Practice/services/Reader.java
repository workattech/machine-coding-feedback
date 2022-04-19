package SnakeAndLadders.Practice.services;

import SnakeAndLadders.Practice.model.*;

import java.util.*;


abstract class ReadInput {
    Board board;

    ReadInput(Board board) {
        this.board = board;
    }
    abstract void readInput();
}

class ReadSnake extends ReadInput {

    ReadSnake(Board board) {
        super(board);
    }

    @Override
    protected void readInput() {
        Scanner scanner = new Scanner(System.in);
        Map<Integer, Snake> snakesList = new HashMap<>();
        int noOfSnakes = scanner.nextInt();
        int start,end;
        for(int i=0;i<noOfSnakes;i++) {
            start = scanner.nextInt();
            end = scanner.nextInt();
            snakesList.put(start,new Snake(start,end));
        }
        board.setSnakes(snakesList);
    }
}

class ReadLadders extends ReadInput {

    ReadLadders(Board board) {
        super(board);
    }

    @Override
    protected void readInput() {
        Scanner scanner = new Scanner(System.in);
        Map<Integer, Ladder> laddersList = new HashMap<>();
        int noOfLadders = scanner.nextInt();
        int start,end;
        for(int i=0;i<noOfLadders;i++) {
            start = scanner.nextInt();
            end = scanner.nextInt();
            laddersList.put(start,new Ladder(start,end));
        }
        board.setLadders(laddersList);
    }
}

class ReadPlayers extends ReadInput {

    ReadPlayers(Board board) {
        super(board);
    }

    @Override
    protected void readInput() {
        Scanner scanner = new Scanner(System.in);
        List<Player>playersList = new ArrayList<>();
        int noOfPlayers = scanner.nextInt();
        String name;
        for(int i=0;i<noOfPlayers;i++) {
            name = scanner.next();
            playersList.add(new Player(0,name));
        }
        board.setPlayers(playersList);
    }
}

public class Reader{
    Board board;

    public Reader(Board board) {
        this.board = board;
    }

    public void read(INPUT_TYPE input) {
        switch (input) {
            case SNAKE: new ReadSnake(board).readInput();break;
            case PLAYERS: new ReadPlayers(board).readInput();break;
            case LADDER: new ReadLadders(board).readInput();break;
        }
    }

}
