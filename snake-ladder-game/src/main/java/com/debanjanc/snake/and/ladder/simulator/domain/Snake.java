package com.debanjanc.snake.and.ladder.simulator.domain;


public class Snake {

	private final Integer head;
	private final Integer tail;

	public Snake(Integer head, Integer tail) {
		this.head = head;
		this.tail = tail;
	}

	public Integer getHead() {
		return head;
	}

	public Integer getTail() {
		return tail;
	}

	@Override
	public String toString() {
		return "Snake [head=" + head + ", tail=" + tail + "]";
	}

	
	
	
	

}