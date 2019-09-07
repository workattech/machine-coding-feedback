package game;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Launcher {
	private final static int BOARD_SIZE = 100;
	private final static int DICE_MIN = 1;
	private final static int DICE_MAX = 6;
	public static void main(String args[]) {
		Game game = new Game(BOARD_SIZE, DICE_MIN,DICE_MAX);
		Scanner sc = new Scanner(System.in);
		List<Snake> listOfSnake = new ArrayList<Snake>();
		List<Ladder> listOfLadder = new ArrayList<Ladder>();
		int snakeCount = sc.nextInt();
		while(snakeCount > 0) {
			int head = sc.nextInt();
			int tail = sc.nextInt();
			listOfSnake.add(new Snake(head, tail));
			snakeCount --;
		}
		int ladderCount = sc.nextInt();
		while(ladderCount > 0) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			listOfLadder.add(new Ladder(start, end));
			ladderCount--;
		}
		// set snakes and ladder
		game.createBoard(listOfSnake, listOfLadder);
		// add Players
		int playerCount = sc.nextInt();
		while(playerCount > 0) {
			String name = sc.next();
			Player p = new Player(name);
			game.addPlayer(p);
			playerCount --;
		}
		// start the game
		game.start();
		sc.close();
	}
}
