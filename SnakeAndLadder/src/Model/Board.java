package Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;

public class Board {
	private int size = 25;
	private HashMap<Integer, Chaos> snake = new HashMap<>();
	private HashMap<Integer, Chaos> ladder = new HashMap<>();
	private ArrayList<Player> player= new ArrayList<>();

	public Board(int size, ArrayList<Player> player) {
		super();
		this.size = size;
		this.player = player;
		generateSnakes();
		generateLadders();
		System.out.println("\n\n============Game Started Now.============");
	}

	private void generateSnakes() {
		int numberOfSnakes = (int) Math.sqrt(size);
		ThreadLocalRandom random = ThreadLocalRandom.current();
		System.out.println("\n\n============Snakes in the game.============");
		for (int i = 0; i < numberOfSnakes; i++) {
			int source = random.nextInt(i*numberOfSnakes+2, (i+1)*numberOfSnakes);
			int dest = random.nextInt(1, source);
			Snake newSnake = new Snake(source, dest);
			snake.put(source, newSnake);
			System.out.println(newSnake);
		}
	}

	private void generateLadders() {
		int numberOfLadders = (int) Math.sqrt(size);
		ThreadLocalRandom random = ThreadLocalRandom.current();
		System.out.println("\n\n============Ladders in the game.============");
		for (int i = 0; i < numberOfLadders; i++) {
			int source = random.nextInt(i*numberOfLadders+1, (i+1)*numberOfLadders);
			int dest = random.nextInt(source, size);
			Ladder newLadder = new Ladder(source, dest);
			ladder.put(source, newLadder);
			System.out.println(newLadder);
		}
		
	}

	public int move(int currPlayer, int roll) {
		Player curr = player.get(currPlayer);
		curr.setNumberOfMoves(curr.getNumberOfMoves()+1);
		int currPos = curr.getPosition();
		int finalPos = getFinalPos(currPos, roll);
		System.out.println(curr.getName()+" rolled "+roll+" and moved from "+currPos+" to finalPos:"+finalPos);
		if(finalPos > size) {
			return curr.getPosition();
		} else {
			curr.setPosition(finalPos);
			return finalPos;
		}
	}

	private int getFinalPos(int currPos, int roll) {
		int finalPos = currPos + roll;
		if(snake.containsKey(finalPos)) {
			return snake.get(finalPos).getFinalPos();
		} else if(ladder.containsKey(finalPos)) {
			return ladder.get(finalPos).getFinalPos();
		}
		return finalPos > size ? currPos : finalPos;
	}
}
