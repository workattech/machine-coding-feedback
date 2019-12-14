package com.workat.tech.service;

import java.util.Random;

public class DiceService {

	public static int rollTheDice() {
		return getRandomInt(1, 6);
	}

	private static int getRandomInt(int min, int max) {
		return new Random().ints(min, max+1).findAny().getAsInt();
	}
}
