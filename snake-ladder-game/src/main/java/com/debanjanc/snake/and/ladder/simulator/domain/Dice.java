package com.debanjanc.snake.and.ladder.simulator.domain;

import org.apache.commons.lang3.RandomUtils;

public abstract class Dice {

	private final int sides;

	protected Dice(int sides) {
		this.sides = sides;
	}

	public int roll() {
		return RandomUtils.nextInt(1, this.sides + 1);
	}

}
