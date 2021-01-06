package services;

import java.util.Random;

public class Dice {
	public int run()
	{
		Random random=new Random();
		return random.nextInt(6)+1;
	}
}
