package Model;

import java.util.UUID;

public class Player {
	private String name;
	private UUID id;
	private int position = 0;
	private int numberOfMoves = 0;
	 
	public Player(String name) {
		super();
		this.name = name;
		this.id = UUID.randomUUID();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public int getNumberOfMoves() {
		return numberOfMoves;
	}

	public void setNumberOfMoves(int numberOfMoves) {
		this.numberOfMoves = numberOfMoves;
	}

	@Override
	public String toString() {
		return "Player is: "+name;
	}
	
}
