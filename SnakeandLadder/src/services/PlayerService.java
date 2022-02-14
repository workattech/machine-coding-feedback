package services;

import entities.Player;
import java.util.Random;

public class PlayerService {

	
	public int rollADice(Player p) {
		
		Random random = new Random();
		
		int num =  random.nextInt(6)+1;
		
		if(p.getPosition()+num > 100) {
			
			return num;
		}
		
		p.setPosition(p.getPosition()+num);
		
		return num;
	}
	
	
	
}
