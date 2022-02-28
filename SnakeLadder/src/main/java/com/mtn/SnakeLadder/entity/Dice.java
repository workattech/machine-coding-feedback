package com.mtn.SnakeLadder.entity;

import java.util.Random;

public class Dice {
	public static CellPosition getRandomNumber(){

        int low = 1;
        Random random = new Random();

        return new CellPosition(low + random.nextInt(6));
    }
}
