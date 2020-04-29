package Model;

public class Snake extends Chaos {
	public Snake(int start, int value) {
		this.startPos = start;
		this.finalPos = value;
	}

	@Override
	public String toString() {
		return "Snake is At [startPos=" + startPos + ", finalPos=" + (finalPos) + "]";
	}
}
