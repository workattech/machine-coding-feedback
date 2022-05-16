package com.practice.snakeAndLadder;
import java.util.Random;

public class Dice {
	private int start;
	private int end;
	public Dice(int start, int end) {
		this.start = start;
		this.end = end;
	}
	public int generateRandomNumber() {
		Random random = new Random();
		return random.nextInt(this.end - this.start + 1) + this.start;
	}
}
