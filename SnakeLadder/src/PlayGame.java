import java.util.ArrayList;
import java.util.HashMap;
import java.util.Queue;
import java.util.LinkedList;


public class PlayGame {
	Board board = null;
	HashMap<Integer, ArrayList<Dynamics>> boardDynamics = new HashMap<Integer, ArrayList<Dynamics>> ();
	HashMap<String, Integer> playersOnBoard = new HashMap<String, Integer>();
	PlayGame (Board currBoard) {
		this.board = currBoard;
		this.playersOnBoard = board.getPlayers();
		this.boardDynamics = board.getboardDynamics();
	}
	
	void start () {
		Queue<String> chance = new LinkedList<String>();
		
		for (String name : playersOnBoard.keySet()) {
			chance.add(name);
		}
		
		//int maxReach = 0;
		while (! chance.isEmpty()) {
			String currentPlayer = chance.poll();
			int currentLocation = playersOnBoard.get(currentPlayer);
			int diceValue = board.rollDice();
			int nextValue = currentLocation + diceValue;
			chance.add(currentPlayer);
			if (nextValue == board.getwinningPoint()) {
				System.out.println(currentPlayer + " wins the game");
				break;
			}
			
			if (nextValue > board.getwinningPoint()) {
				System.out.println(currentPlayer + " rolled a " + diceValue + " and moved from " + currentLocation + " to " + currentLocation);
				continue;
			}
			
			ArrayList<Dynamics> snakesLadders = boardDynamics.containsKey(nextValue) ? boardDynamics.get(nextValue) : null;
			if (snakesLadders == null) {
				playersOnBoard.put(currentPlayer, nextValue);
			}
			
			else {
				int endPoint = snakesLadders.get(0).getendLocation();
				if (endPoint == board.getwinningPoint()) {
					System.out.println(currentPlayer + " wins the game");
					break;
				}
				else	
					playersOnBoard.put(currentPlayer, endPoint);
			}
			
			System.out.println(currentPlayer + " rolled a " + diceValue + " and moved from " + currentLocation + " to " + playersOnBoard.get(currentPlayer));
		}
	}
}
