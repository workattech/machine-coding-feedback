package com.debanjanc.snake.and.ladder.simulator.domain;

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



	@Override
	public String toString() {
		return "Cell [number=" + this.number + ", effectiveCell=" + this.effectiveCell.number + "]";
	}
	
	

}
