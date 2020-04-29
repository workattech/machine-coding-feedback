package Model;

public class Ladder extends Chaos {
	public Ladder(int start, int value) {
		this.startPos = start;
		this.finalPos = value;
	}

	@Override
	public String toString() {
		return "Ladder is At [startPos=" + startPos + ", finalPos=" + (finalPos) + "]";
	}
}
