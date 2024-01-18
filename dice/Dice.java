package dice;

import java.util.Random;

public class Dice {
	public int generateScore(){
        Random rand = new Random();
        return rand.nextInt(6)+1; 
    }
}
