package main.java.model;

import java.util.Random;

public class Dice {
	private int[] values = { 1, 2, 3, 4, 5, 6 };
	private Random rand = new Random();

	public int getValue() {
		return values[rand.nextInt(6)];
	}
}
