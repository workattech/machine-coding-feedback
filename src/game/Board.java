package game;

import java.util.HashMap;
import java.util.Map;

public class Board {
	private final Map<Integer,Position> map;
	private final int size;
	public Board(int size) {
		super();
		this.size = size;
		this.map = new HashMap<Integer, Position>();
		initializeBoard(size);
	}
	public Map<Integer, Position> getMap() {
		return map;
	}
	public int getSize() {
		return size;
	}
	private final void initializeBoard(int size) {
		for(int i = 1; i <= size ; i++) {
			map.put(i, new Position(i));
		}
	}
	public void placeSnake(Snake s) {
		Position snakeHeadPosition = map.get(s.getHeadIndex());
		snakeHeadPosition.setSnake(s);
	}
	public void placeLadder(Ladder ladder) {
		Position ladderStartPosition = map.get(ladder.getStartIndex());
		ladderStartPosition.setLadder(ladder);
	}
	public void moveToPosition(Player player, Position pos) {
		while(pos.hasLadder() || pos.hasSnake()) {
			if(pos.hasSnake()) {
				pos = map.get(pos.getSnake().getTailIndex());
			}
			else if(pos.hasLadder()) {
				pos = map.get(pos.getLadder().getEndIndex());
			}
		}
		player.setCurrentPosition(pos);
	}
	public Position getPositionOnBoard(int index) {
		return map.get(index);
	}
}
