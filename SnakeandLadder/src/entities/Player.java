package entities;

public class Player {

	String name;
	int turn;
	int position;
	
	public Player(String name, int turn, int position) {
		
		this.name= name;
		this.turn = turn;
		this.position = position;
		
	}
	
	public int getTurn() {
		return turn;
	}
	public String getName() {
		return name;
	}
	
	public int getPosition() {
		return position;
	}
	
	public void setPosition(int position) {
		
		this.position = position;
	}
	
}
