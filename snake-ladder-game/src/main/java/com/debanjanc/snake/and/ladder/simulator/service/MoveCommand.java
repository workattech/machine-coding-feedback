package com.debanjanc.snake.and.ladder.simulator.service;

public interface MoveCommand {
	
	public void call();
	
	public void undo();

}
