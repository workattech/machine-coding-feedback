package game;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class Game {
	private final Board board;
	private Deque<Player> players;
	private final Dice dice;
	
	public Game(int boardSize, int diceMinValue, int diceMaxValue) {
		this.board = new Board(boardSize);
		this.dice = new Dice(diceMinValue, diceMaxValue);
		this.players = new ArrayDeque<Player>();
	}
	public void addPlayer(Player player) {
		players.add(player);
	}
	public void createBoard(List<Snake> snakes, List<Ladder> ladders) {
		for(Snake snake: snakes) {
			board.placeSnake(snake);
		}
		for(Ladder ladder: ladders) {
			board.placeLadder(ladder);
		}
	}
	
	public void start() {
		if(players.size() == 0)
		{
			System.out.println("No players");
			return;
		}
		Player currentPlayer = players.remove();
		while(true) {
			int diceVal = dice.rollMe();
			int currPosValue = currentPlayer.getCurrentPosition().getIndex();
			int newPositionValue = currPosValue + diceVal;
			if(newPositionValue <= board.getSize()) {
				Position newPosition = board.getPositionOnBoard(newPositionValue);
				board.moveToPosition(currentPlayer, newPosition);
				if(currentPlayer.getCurrentPosition().getIndex() == board.getSize()) {
					System.out.println(currentPlayer.getName() +" wins the game" );
					break;
				}
			}
			System.out.println(currentPlayer.getName()+ " rolled a "+diceVal+ " and moved from "+ currPosValue+" to " +currentPlayer.getCurrentPosition().getIndex());
			players.add(currentPlayer);
			currentPlayer = players.remove();
		}
	}
	
}
