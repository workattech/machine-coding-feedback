package game;

public class Position {
	private final int index;
	private Snake snake;
	private Ladder ladder;
	public Position(int index) {
		super();
		this.index = index;
		this.snake = null;
		this.ladder = null;
	}
	public int getIndex() {
		return index;
	}
	public Snake getSnake() {
		return snake;
	}
	public void setSnake(Snake snake) {
		this.snake = snake;
	}
	public Ladder getLadder() {
		return ladder;
	}
	public void setLadder(Ladder ladder) {
		this.ladder = ladder;
	}
	public boolean hasSnake() {
		return this.snake!=null;
	}
	public boolean hasLadder() {
		return this.ladder!=null;
	}
}
