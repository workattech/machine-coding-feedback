package com.debanjanc.snake.and.ladder.simulator.domain;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class Cell implements Comparable<Cell> {

	private final Integer number;

	private Cell effectiveCell;
	
	public Cell(Integer number) {
		this.number = number;
		this.effectiveCell = this;
	}

	

	public Integer getNumber() {
		return number;
	}

	public Cell getEffectiveCell() {
		return effectiveCell;
	}
	
	public void setEffectiveCell(Cell effectiveCell) {
		this.effectiveCell = effectiveCell;
	}

	public int compareTo(Cell other) {
		return Integer.compare(this.number, other.number);
	}
	

}
