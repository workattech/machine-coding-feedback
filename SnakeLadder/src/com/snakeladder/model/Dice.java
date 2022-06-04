package com.snakeladder.model;

import java.util.Random;

public class Dice {
	int max = 6;
	int min = 0;
	
	
	
	public Dice() {
		super();
		this.max = 6;
		this.min = 1;
	}

	public int roll(){
		Random rand = new Random();
		return rand.nextInt((this.max-min)+1)+min;
	}
}
