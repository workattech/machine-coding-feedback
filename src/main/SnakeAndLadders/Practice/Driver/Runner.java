package SnakeAndLadders.Practice.Driver;

import SnakeAndLadders.Practice.Model.Board;
import SnakeAndLadders.Practice.Model.Dice;
import SnakeAndLadders.Practice.Model.INPUT_TYPE;
import SnakeAndLadders.Practice.Model.SingleDiceRoll;
import SnakeAndLadders.Practice.Services.BoardGame;
import SnakeAndLadders.Practice.Services.Reader;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Board board = new Board();
        Reader reader = new Reader(board);
        Dice dice = new SingleDiceRoll();

        System.out.println("Reading snakes");
        reader.read(INPUT_TYPE.SNAKE);

        System.out.println("Reading ladders");
        reader.read(INPUT_TYPE.LADDER);

        System.out.println("Reading players");
        reader.read(INPUT_TYPE.PLAYERS);
        board.setDice(dice);

        BoardGame game = new BoardGame(board);
        game.startGame();

    }
}
