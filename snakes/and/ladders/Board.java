package practice.snakes.and.ladders;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.Data;

@Data
public class Board {

	private Map<Integer, Cell> cells;
	private List<Snake> snakes;
	private List<Ladder> ladders;
	public static final int BOARD_SIZE = 100;
	
	public Board() {
		this.cells = new HashMap<>();
		this.snakes = new ArrayList<>();
		this.ladders = new ArrayList<>();
		this.buildBoard();
	}
	
	public void addSnake(int head, int tail) {
		this.snakes.add(new Snake(head, tail));
	}
	
	public void addLadder(int start, int end) {
		this.ladders.add(new Ladder(start, end));
	}
	
	private void buildBoard() {
		for (int i=1; i<=BOARD_SIZE; i++) {
			this.cells.put(i, new Cell());
		}
	}
	
	public void addSnakesAndLadders() {
		snakes.forEach(snake -> cells.get(snake.getHead()).setSnake(snake));
		ladders.forEach(ladder -> cells.get(ladder.getStart()).setLadder(ladder));
	}
}
