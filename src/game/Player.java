package game;

public class Player {
	private String name;
	private Position currentPosition;
	public Player(String name) {
		super();
		this.name = name;
		//player always start at 0
		this.currentPosition = new Position(0);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Position getCurrentPosition() {
		return currentPosition;
	}
	public void setCurrentPosition(Position currentPosition) {
		this.currentPosition = currentPosition;
	}
	
}
