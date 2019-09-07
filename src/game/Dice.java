package game;

import java.util.Random;

public class Dice {
	private final int minValue;
	private final int maxValue;
	public Dice(int minValue, int maxValue) {
		super();
		this.minValue = minValue;
		this.maxValue = maxValue;
	}
	public int getMinValue() {
		return minValue;
	}
	public int getMaxValue() {
		return maxValue;
	}
	
	public int rollMe() {
		Random r = new Random();
		return (r.nextInt((maxValue-minValue)+1) + minValue);
	}
}
