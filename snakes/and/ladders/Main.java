package practice.snakes.and.ladders;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Game game = new Game();
		
		Scanner scanner = new Scanner(System.in);
		int noOfSnakes = scanner.nextInt();
		
		for (int i=1; i<=noOfSnakes; i++) {
			int head = scanner.nextInt();
			int tail = scanner.nextInt();
			game.getBoard().addSnake(head, tail);
		}
		
		int noOfLadders = scanner.nextInt();
		for (int i=1; i<=noOfLadders; i++) {
			int start = scanner.nextInt();
			int end = scanner.nextInt();
			game.getBoard().addLadder(start, end);
		}
		
		
		int noOfPlayers = scanner.nextInt();
		for (int i=1; i<=noOfPlayers; i++) {
			String name = scanner.next();
			game.addPlayer(name);
		}
		
		game.startGame();
		scanner.close();
	}

}
