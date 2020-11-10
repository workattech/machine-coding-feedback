import java.util.HashMap;
import java.util.ArrayList;

public class Board {
	private HashMap<Integer, ArrayList<Dynamics>> boardDynamics = new HashMap<Integer, ArrayList<Dynamics>>();
	private HashMap<String, Integer> playeronBoard = new HashMap<String, Integer>();
	private int winningPoint = 0;
	
	Board (int dimensionX, int dimensionY, ArrayList<Dynamics> snakeList, ArrayList<Dynamics> ladderList, ArrayList<String> usersList) {
		winningPoint = dimensionX * dimensionY;
		for (Dynamics eachSnake : snakeList) {
			int snakeBitePoint = eachSnake.getstartLocation();
			boardDynamics.put(snakeBitePoint, new ArrayList<Dynamics>());
			ArrayList<Dynamics> curr = boardDynamics.get(snakeBitePoint);
			curr.add(eachSnake);
		}
		
		for (Dynamics eachLadder : ladderList) {
			int ladderStart = eachLadder.getstartLocation();
			if (! boardDynamics.containsKey(ladderStart))
				boardDynamics.put(ladderStart, new ArrayList<Dynamics>());
			
			ArrayList<Dynamics> curr = boardDynamics.get(ladderStart);
			curr.add(eachLadder);
		}
		
		for (String name : usersList)
			playeronBoard.put(name, 0);
	}
	
	int rollDice () {
		return (int) (Math.random() * 6 + 1);
	}
	
	public HashMap<String, Integer> getPlayers () {
		return playeronBoard;
	}
	
	public int getwinningPoint () {
		return winningPoint;
	}
	
	public HashMap<Integer, ArrayList<Dynamics>> getboardDynamics () {
		return boardDynamics;
	}
	
	
}
