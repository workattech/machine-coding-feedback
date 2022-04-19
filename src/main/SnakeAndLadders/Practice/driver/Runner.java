package SnakeAndLadders.Practice.driver;

import SnakeAndLadders.Practice.model.Board;
import SnakeAndLadders.Practice.model.Dice;
import SnakeAndLadders.Practice.model.INPUT_TYPE;
import SnakeAndLadders.Practice.model.SingleDiceRoll;
import SnakeAndLadders.Practice.services.BoardGame;
import SnakeAndLadders.Practice.services.Reader;

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
