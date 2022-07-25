package game;

public class Snake {
	private final int headIndex;
	private final int tailIndex;
	public Snake(int headIndex, int tailIndex) {
		super();
		this.headIndex = headIndex;
		this.tailIndex = tailIndex;
	}
	public int getHeadIndex() {
		return headIndex;
	}
	public int getTailIndex() {
		return tailIndex;
	}
}
