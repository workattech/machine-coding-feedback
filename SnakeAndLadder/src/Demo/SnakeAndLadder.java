package Demo;
import java.util.ArrayList;

import Model.Board;
import Model.Dice;
import Model.Player;

public class SnakeAndLadder {
	private int numberOfPlayers;
	private int boardSize;
	private ArrayList<Player> players = new ArrayList<>();
	
	
	public SnakeAndLadder(ArrayList<String> names) {
		super();
		this.numberOfPlayers = names.size();
		this.boardSize = 100;
		for (String name : names) {
			players.add(new Player(name));
		}
	}

	public void start() {
		Board board = new Board(boardSize, players);
		int currPlayer = 0;
		Dice dice = new Dice(6);
		while (true) {
			int roll = dice.roll();
			int newPos = board.move(currPlayer, roll);
			if(newPos == boardSize) {
				Player winner = players.get(currPlayer);
				System.out.print("\n\nWinner is: "+winner.getName());
				System.out.println("  Total Number of Moves: "+winner.getNumberOfMoves());
				return;
			}
			currPlayer = (currPlayer+1)%numberOfPlayers;
		}
		
	}

	@Override
	public String toString() {
		return "SnakeAndLadder [numberOfPlayers=" + numberOfPlayers + ", players=" + players.toString() + "]";
	}
	
	
}
