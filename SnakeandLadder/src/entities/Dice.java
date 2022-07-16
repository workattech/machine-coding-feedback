package entities;
import java.util.concurrent.ThreadLocalRandom;

public class Dice {

	
	private int numDices = 1;
	
	public Dice() {}
	
	public Dice(int n) {
		this.numDices = n;
	    	
	}
	
	public int rollDice() {
		
		return ThreadLocalRandom.current().nextInt(numDices, 6*numDices + 1); 
				}
	
}
