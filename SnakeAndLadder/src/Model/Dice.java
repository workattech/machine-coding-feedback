package Model;

import java.util.Random;

public class Dice {
	private int maxValueOnRoll;
	
	public Dice(int maxValueOnRoll) {
		super();
		this.maxValueOnRoll = maxValueOnRoll;
	}

	public int roll() {
		int value = new Random().nextInt(maxValueOnRoll)+1;
		return value;
	}

}
