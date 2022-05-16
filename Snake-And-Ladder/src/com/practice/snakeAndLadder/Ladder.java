package com.practice.snakeAndLadder;

public class Ladder extends SnakeLadder {
	private int start;
	private int end;
	public Ladder(int start, int end) {
		this.start = start;
		this.end = end;
	}
	public int getStart() {
		return start;
	}
	public int getEnd() {
		return end;
	}
}
