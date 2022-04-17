package com.practice.snakeAndLadder;

public class Snake extends SnakeLadder {
	private int head;
	private int tail;
	public Snake(int head, int tail) {
		this.head = head;
		this.tail = tail;
	}
	public int getHead() {
		return head;
	}
	public int getTail() {
		return tail;
	}
}
