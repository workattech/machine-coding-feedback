package com.debanjanc.snake.and.ladder.simulator.domain;

public class Ladder {
	private final Integer start;
	private final Integer end;

	public Integer getStart() {
		return start;
	}

	public Integer getEnd() {
		return end;
	}

	public Ladder(Integer start, Integer end) {
		this.start = start;
		this.end = end;
	}
	
}
